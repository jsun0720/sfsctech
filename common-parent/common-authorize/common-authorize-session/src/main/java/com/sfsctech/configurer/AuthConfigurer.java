package com.sfsctech.configurer;

import com.sfsctech.constants.LabelConstants;
import com.sfsctech.authorize.session.filter.SessionFilter;
import com.sfsctech.spring.properties.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class AuthConfigurer
 *
 * @author 张麒 2017/9/4.
 * @version Description:
 */
@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
public class AuthConfigurer {

    @Autowired
    private AppConfig appConfig;

    @Bean
    public FilterRegistrationBean SessionFilter() {
        SessionFilter filter = new SessionFilter();
        // Session认证排除路径
        filter.setExcludesPattern(appConfig.getSessionExcludePath());
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.addUrlPatterns(LabelConstants.SLASH_STAR);
        registration.setName("SessionFilter");
        return registration;
    }

}