package com.zwy.accounting;

import com.zwy.accounting.common.exception.BusinessException;
import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

//开启全局异常监听
@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(Logger.class);
    private final static int DEFAULT_ERROR_CODE = 99999;
    private final static int SQL_ERROR_CODE = 99990;

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result noHandlerFoundException(Exception ex) {
        logger.error("================="+ex.getLocalizedMessage()+"=================");
        return ResultUtil.error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result constraintViolationException(ConstraintViolationException ex) {
        logger.error("================="+ex.getLocalizedMessage()+"=================");
        return ResultUtil.error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result defaultErrorHandler(Exception ex) {
        ex.printStackTrace();
        logger.error("================="+ex.getLocalizedMessage()+"=================");
        return ResultUtil.error(DEFAULT_ERROR_CODE, ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = DataAccessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result sqlErrorHandler(DataAccessException ex) {
        ex.printStackTrace();
        logger.error("================="+ex.getLocalizedMessage()+"=================");
        return ResultUtil.error(SQL_ERROR_CODE, ex.getCause().toString());
    }

    /**
     * 业务异常全局处理。业务异常视为成功请求，即responseStatus返回200
     *
     * @param ex 业务异常实例
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result businessErrorHandler(BusinessException ex) {
        ex.printStackTrace();
        logger.error("================="+ex.getMsg()+"=================");
        return ResultUtil.error(ex.getCode(), ex.getMsg());
    }
}
