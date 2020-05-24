package com.example.demo;



import org.example.FormatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @className TestController
 * @description TODO
 * @date {DATE}{TIME}
 */
@RestController
public class TestController {
//    public static void main( String[] args )
////    {
////        Map hashMap=new HashMap();
////        hashMap.put("name","123");
////        StringFormatProcessor processor = new StringFormatProcessor();
////        FormatTemplate formatTemplate=new FormatTemplate(processor);
////        System.out.println(formatTemplate.doFormat(hashMap));
////    }
    @Autowired
   private FormatTemplate formatTemplate;

    @GetMapping("/test")
    public String testFormat(){
        Map hashMap=new HashMap();
        hashMap.put("name","123");
       return formatTemplate.doFormat(hashMap);
    }

}
