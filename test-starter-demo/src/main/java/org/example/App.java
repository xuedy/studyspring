package org.example;

import org.example.format.FormatProcessor;
import org.example.format.JsonFormatProcessor;
import org.example.format.StringFormatProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map hashMap=new HashMap();
        hashMap.put("name","123");
        FormatProcessor processor=new StringFormatProcessor();
        FormatTemplate formatTemplate=new FormatTemplate(processor);
        System.out.println(formatTemplate.doFormat(hashMap));
    }
}
