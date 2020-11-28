package com.dong.unified.web;

import com.dong.unified.ServiceExceptionEnum;
import com.dong.unified.exception.ServiceException;
import com.dong.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;


/**
 * @author DongJian
 * @date Created in 2020/11/28 16:45
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@Slf4j
@ControllerAdvice(basePackages = "com.dong.unified") //指定包
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public CommonResult serviceExceptionHanlder(HttpServletRequest req, ServiceException ex) {
        log.error("serviceExceptionHanlder",ex);
        return CommonResult.error(ex.getCode(),ex.getMessage());
    }
    /**
     * 处理 MissingServletRequestParameterException 异常
     *
     * SpringMVC 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {
        log.debug("[missingServletRequestParameterExceptionHandler]", ex);
        // 包装 CommonResult 结果
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e) {
        // 记录异常日志
        log.error("[exceptionHandler]", e);
        // 返回 ERROR CommonResult
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
