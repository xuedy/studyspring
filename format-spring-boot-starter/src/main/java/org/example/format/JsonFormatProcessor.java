package org.example.format;

import com.alibaba.fastjson.JSON;

/**
 * @author Administrator
 * @className JsonFormatProcessor
 * @description TODO
 * @date {DATE}{TIME}
 */
public class JsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "JsonFormat  "+ JSON.toJSONString(obj);
    }
}
