package org.example.format;

/**
 * @author Administrator
 * @className FormatProcessor
 * @description TODO
 * @date {DATE}{TIME}
 */
public interface FormatProcessor {
    <T> String format(T obj);
}
