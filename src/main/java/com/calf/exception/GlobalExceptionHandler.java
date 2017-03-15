package com.calf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统统一异常处理控制类
 *
 * @author calf
 * @create 2017-03-13 12:01
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        info.setData(e.getMessage());
        return info;
    }

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, JsonException e) throws Exception {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        info.setData("error data");
        return info;
    }
}
