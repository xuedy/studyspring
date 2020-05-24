package org.example.format;

import java.util.Objects;

/**
 * @author Administrator
 * @className StringFormatProcessor
 * @description TODO
 * @date {DATE}{TIME}
 */
public class StringFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "StringFormat  "+Objects.toString(obj);
    }
}
