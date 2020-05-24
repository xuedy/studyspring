package org.example;

import org.example.autoconfiguration.HelloProperties;
import org.example.format.FormatProcessor;

/**
 * @author Administrator
 * @className FormatTemplete
 * @description TODO
 * @date {DATE}{TIME}
 */
public class FormatTemplate {


    private FormatProcessor formatProcessor;
    private HelloProperties helloProperties;


    public FormatTemplate(FormatProcessor formatProcessor,HelloProperties helloProperties) {
        this.formatProcessor = formatProcessor;
        this.helloProperties = helloProperties;
    }

    public <T> String doFormat(T obj){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("DO Format:").append("<br/>");
        stringBuilder.append("HelloProperties： ").append(formatProcessor.format(helloProperties.getInfo())).append("<br/>");
        stringBuilder.append("Obj format result：").append(formatProcessor.format(obj)).append("<br/>");
        return stringBuilder.toString();
    }
}
