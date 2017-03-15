package com.calf.exception;

/**
 * 自定义JSON异常类
 *
 * @author calf
 * @create 2017-03-13 12:24
 */
public class JsonException extends Exception {

    public JsonException(String message) {
        super(message);
    }
}
