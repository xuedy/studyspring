package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xuedy.PayService;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        PayService payService =null;
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/application.xml"});
        context .start();
        payService= (PayService) context.getBean("payService");
        System.out.println( payService);
        System.out.println( "Hello World!"+context );
        System.out.println(payService.doPay("100万") );
        System.in.read();


    }
}
art rtart