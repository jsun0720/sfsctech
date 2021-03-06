package com.sfsctech.core.exception.controller;

import com.sfsctech.core.base.constants.CommonConstants;
import com.sfsctech.core.base.constants.RpcConstants.Status;
import com.sfsctech.core.base.domain.result.BaseResult;
import com.sfsctech.core.base.ex.GenericException;
import com.sfsctech.core.exception.ex.BizException;
import com.sfsctech.core.exception.ex.RpcException;
import com.sfsctech.core.exception.ex.VerifyException;
import com.sfsctech.core.exception.handler.BaseExceptionHandler;
import com.sfsctech.core.spring.constants.I18NConstants;
import com.sfsctech.core.spring.util.ResourceUtil;
import com.sfsctech.support.common.util.HttpUtil;
import com.sfsctech.support.common.util.ThrowableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class GlobalExceptionHandler
 *
 * @author 张麒 2017/3/29.
 * @version Description:
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler {

    @Autowired
    private MultipartProperties multipart;

    private String getMessage(GenericException e, HttpServletRequest request) {
        if (null != e.getTips())
            return ResourceUtil.getMessage(e.getTips().getCode(), request.getLocale(), e.getParams());
        else
            return e.getMessage();
    }

    /**
     * 业务异常捕获
     */
    @ExceptionHandler(BizException.class)
    public ModelAndView runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, BizException e) {
        String message = getMessage(e, request);
        logger.info("业务异常捕获：" + message);
        BaseResult result = new BaseResult(Status.Failure, message);
        return handleError(request, response, result, e.getViewName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * RPC异常捕获
     */
    @ExceptionHandler(RpcException.class)
    public ModelAndView runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, RpcException e) {
        String message = getMessage(e, request);
        logger.info("RPC异常捕获：" + message + "--" + e.getCause().toString());
        BaseResult result = new BaseResult(Status.PayloadTooLarge, message);
        return handleError(request, response, result, e.getViewName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 校验异常捕获
     */
    @ExceptionHandler(VerifyException.class)
    public ModelAndView runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, VerifyException e) {
        String message = getMessage(e, request);
        logger.warn("校验异常捕获：" + message);
        BaseResult result = new BaseResult(Status.Failure, message);
        result.addAttach(CommonConstants.MESSAGES_DETAILS, e.getResult());
        return handleError(request, response, result, CommonConstants.VIEW_500, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 404异常捕获
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handle404Error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.warn("404异常捕获：{message:" + ThrowableUtil.getRootMessage(e) + ",ip:" + HttpUtil.getRequestIP(request) + "}");
        BaseResult result = new BaseResult(Status.NotFound, ResourceUtil.getMessage(I18NConstants.Tips.Exception404.getCode(), request.getLocale()));
        return handleError(request, response, result, CommonConstants.VIEW_404, HttpStatus.NOT_FOUND);
    }

    /**
     * 文件上传异常捕获
     */
    @ExceptionHandler({MultipartException.class})
    public ModelAndView handleError(HttpServletRequest request, HttpServletResponse response, MultipartException e) {
        logger.warn("文件上传异常捕获：" + ThrowableUtil.getStackTraceMessage(e));
        BaseResult result = new BaseResult(Status.PayloadTooLarge, ResourceUtil.getMessage(I18NConstants.Tips.ExceptionUpload.getCode(), request.getLocale(), multipart.getMaxFileSize()));
        return handleError(request, response, result, CommonConstants.VIEW_500, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 系统异常捕获
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("系统异常捕获：" + ThrowableUtil.getStackTraceMessage(e), e);
        BaseResult result = new BaseResult(Status.ServerError, ResourceUtil.getMessage(I18NConstants.Tips.ExceptionService.getCode(), request.getLocale()));
        return handleError(request, response, result, CommonConstants.VIEW_500, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
