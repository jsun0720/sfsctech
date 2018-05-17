package com.sfsctech.common.core.security.interceptor;

import com.alibaba.fastjson.JSON;
import com.sfsctech.common.core.base.domain.dto.BaseDto;
import com.sfsctech.common.core.base.filter.FilterHandler;
import com.sfsctech.common.core.security.csrf.CSRFTokenManager;
import com.sfsctech.common.core.security.tools.SecurityUtil;
import com.sfsctech.common.support.util.HttpUtil;
import com.sfsctech.common.support.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Class SecurityInterceptor
 *
 * @author 张麒 2017/7/19.
 * @version Description:
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    private Set<String> excludesPattern;

    private Set<String> verifyPattern;

    public void setExcludesPattern(Set<String> excludesPattern) {
        this.excludesPattern = excludesPattern;
    }

    public void setVerifyPattern(Set<String> verifyPattern) {
        this.verifyPattern = verifyPattern;
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//        }
        String requestURI = request.getRequestURI();
        boolean excludes = FilterHandler.isExclusion(requestURI, excludesPattern);
        boolean verify = FilterHandler.isExclusion(requestURI, verifyPattern);
        logger.info("exclusion：[" + excludes + "] request uri：[" + requestURI + "] ");
        // 当前请求路径是否需要验证 && Csrf防御验证
        if ((!excludes || verify) && CSRFTokenManager.isValidCSRFToken(request, response)) {
            logger.warn("CSRF attack intercept");
            // TODO
//            throw new BizException(I18NConstants.Tips.Exception403);
        }
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle：[" + request.getRequestURI() + "] ");
        Method method = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            method = handlerMethod.getMethod();
        }
        // 如果是Ajax请求，返回类型是String，csrf参数设置至Header
        if (HttpUtil.isAjaxRequest(request) && null != method && method.getReturnType() == String.class) {
            response.setHeader(CSRFTokenManager.CSRF_TOKEN, JSON.toJSONString(CSRFTokenManager.generateCSRFToken(request, response)));
        }
        // 如果不是Ajax请求，返回类型是String，csrf参数设置至ModelAndView
        else if (!HttpUtil.isAjaxRequest(request) && null != modelAndView && null != modelAndView.getModel()) {
            // 加密敏感参数
            Map<String, Object> model = modelAndView.getModel();
            for (String key : model.keySet()) {
                Object obj = model.get(key);
                if (BaseDto.class.equals(obj.getClass().getSuperclass())) {
                    SecurityUtil.Encrypt(obj);
                }
            }
            // 设置Csrf Token
            model.put(CSRFTokenManager.CSRF_TOKEN, CSRFTokenManager.generateCSRFToken(request, response));
        }
        // 设置无缓存，防止浏览器回退操作
        ResponseUtil.setNoCacheHeaders(response);
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 会在Controller方法异步执行时开始执行
     *
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }
}