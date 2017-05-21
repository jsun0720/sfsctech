package com.sfsctech.common.spring.util;

import com.sfsctech.common.spring.properties.AppConfig;
import com.sfsctech.common.util.ByteSizeUtil;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

/**
 * Class SpringUtil
 *
 * @author 张麒 2017/5/11.
 * @version Description:
 */
@Component
public class JavaConfigUtil {

    @Resource
    private AppConfig appConfig;

    public ServletRegistrationBean getServletRegistrationBean(DispatcherServlet servlet) {
        // 404请求抛出NoHandlerFoundException
        servlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
        // 上传文件配置
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(appConfig.MULTIPART_LOCATION, ByteSizeUtil.parseBytesSize(appConfig.MULTIPART_MAX_FILE_SIZE), ByteSizeUtil.parseBytesSize(appConfig.MULTIPART_MAX_REQUEST_SIZE), appConfig.MULTIPART_FILE_SIZE_THRESHOLD);
        registration.setMultipartConfig(multipartConfigElement);
        return registration;
    }
}
