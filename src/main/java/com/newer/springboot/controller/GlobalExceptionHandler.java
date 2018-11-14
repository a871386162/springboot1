package com.newer.springboot.controller;

import com.newer.springboot.Exception.HospitalException;
import com.newer.springboot.domain.ErrorInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 统一的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_VIEW_NAME="error";

    /*@ExceptionHandler(value = HospitalException.class)
    public ModelAndView exceptionHandle(HttpServletRequest request,HospitalException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",e.getMessage());
        modelAndView.addObject("url",request.getRequestURL().toString());
        modelAndView.addObject("data",mapToStr(request.getParameterMap()));
        modelAndView.setViewName(ERROR_VIEW_NAME);
        return modelAndView;
    }*/

    @ExceptionHandler(value = HospitalException.class)
    @ResponseBody
    public ErrorInfo<String>jsonException(HttpServletRequest request,HospitalException e)throws Exception{
        ErrorInfo<String>errorInfo = new ErrorInfo<>();
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setData(mapToStr(request.getParameterMap()));
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        return errorInfo;
    }
    private String mapToStr(Map<String,String[]>map){
        StringBuffer sb = new StringBuffer();
        if(map!=null){
            for(Map.Entry<String,String[]> str:map.entrySet()){
                sb.append(str.getKey()+":"+str.getValue());
            }
        }
        return sb.toString();
    }
}

