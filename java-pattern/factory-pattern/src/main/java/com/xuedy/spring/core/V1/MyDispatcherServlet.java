package com.xuedy.spring.core.V1;

import com.xuedy.spring.core.annotation.MyAutowired;
import com.xuedy.spring.core.annotation.MyController;
import com.xuedy.spring.core.annotation.MyRequestMapping;
import com.xuedy.spring.core.annotation.MyService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class MyDispatcherServlet extends HttpServlet {
    //定义Bean容器
    private Map<String,Object> myHandlerMapping =new ConcurrentHashMap<String,Object>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
    }

    /**
     * My Dispatcher Servlet init
     * 初始化调度Servlet
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        InputStream inputStream=null;
        try {
            Properties configContext=new Properties();
            //获取配置文件流
            inputStream=this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));
            //加载配置文件中的信息
            configContext.load(inputStream);
            //获取需要扫描的基础包路径
            String scanPackage=configContext.getProperty("scanPackage");
            //扫描包，填充myHandlerMapping
            doScanner(scanPackage);
            //便利容器myHandlerMapping，的key，给赋值
            for (String className :myHandlerMapping.keySet()){
                //不是类名直接跳过处理
                if(!className.contains(".")){continue;}
                //加载类对象
                Class<?> clazz=Class.forName(className);

                //如果是被@MyController注解的类
                if(clazz.isAnnotationPresent(MyController.class)){
                    //存放映射关系
                    myHandlerMapping.put(className,clazz.newInstance());
                    String baseUrl="";
                    if(clazz.isAnnotationPresent(MyRequestMapping.class)){
                        //获取标记注解的对象
                        MyRequestMapping myRequestMapping=clazz.getAnnotation(MyRequestMapping.class);
                        //获取标记对象上的注解值
                        baseUrl=myRequestMapping.value();
                    }
                    //获取类中的所有方法
                    Method[] methods=clazz.getMethods();
                    //便利所有的方法
                    for (Method method:methods){
                        //方法上没有注解@MyRequestMapping 就跳过
                        if(!method.isAnnotationPresent(MyRequestMapping.class)){ continue;}
                        //获取注解对象 myRequestMapping
                         MyRequestMapping myRequestMapping=method.getAnnotation(MyRequestMapping.class);
                         //获取注解对象上的值
                         String url=baseUrl+myRequestMapping.value();
                         myHandlerMapping.put(url,method);
                         System.out.println("mapped "+url+" ,"+method);
                    }

                }
                //如果是被 @MyService 注解的类
                else if(clazz.isAnnotationPresent(MyService.class)){
                     //获取标记了@MyService 的对象
                     MyService myService= clazz.getAnnotation(MyService.class);
                     //获取@MyService 上的value
                     String beanName=myService.value();
                     //如果没有指定别名，就默认类名
                     if("".equals(beanName)){beanName=clazz.getName();}
                     Object  object =clazz.newInstance();
                     myHandlerMapping.put(beanName,object);
                     //便利实现的接口，放到myHandlerMapping
                     for (Class<?> it :clazz.getInterfaces()){
                         myHandlerMapping.put(it.getName(),object);
                     }
                }
                else{ continue;}
            }
            //对容器中存储的对象进行便利，并对@MyController标记的类中的字段进行赋值，
            for (Object object:myHandlerMapping.values()){
                //如果存储的对象是空 就跳过
                if(object==null){continue;}
                Class<?> clazz =object.getClass();
                //如果有@MyController注解标记
                if(clazz.isAnnotationPresent(MyController.class)){
                    Field[] fields =clazz.getDeclaredFields();
                    //便利所有字段
                    for (Field field:fields){
                        //跳过所有没有标记@MyAutowired的字段
                        if(!field.isAnnotationPresent(MyAutowired.class)){continue;}
                        MyAutowired myAutowired=clazz.getAnnotation(MyAutowired.class);
                        String beanName=myAutowired.value();
                        //没有value，类名做beanName
                        if("".equals(beanName)){beanName=clazz.getName();}
                        field.setAccessible(true);
                        //取容器中的值，给字段赋值 就是DI
                        field.set(myHandlerMapping.get(clazz.getName()),myHandlerMapping.get(beanName));

                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭流
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.init(config);
    }

    /**
     * //扫描包路径下的所有文件名称，加载到myHandlerMapping容器当中
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        //将包路径上的. 转化为系统的路径（windows/  linux \）
        URL url=this.getClass().getClassLoader().getResource(System.lineSeparator()+scanPackage.replaceAll("\\.",System.lineSeparator()));
        //获取路径下的所有文件
        File classDir=new File(url.getFile());
        //循环遍历文件
        for (File file :classDir.listFiles()){
            //是路径就递归
            if(file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else{
                //不是class文件就跳过
                if (!file.getName().endsWith(".class")){continue;}
                myHandlerMapping.put(file.getName().replace(".class",""),null);
            }
        }
    }
}
