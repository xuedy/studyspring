package org.xuedy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/application.xml"});
        context .start();
        System.out.println( context.getBean("payService"));
        System.out.println( "Hello World!"+context );
        System.in.read();
    }
}
