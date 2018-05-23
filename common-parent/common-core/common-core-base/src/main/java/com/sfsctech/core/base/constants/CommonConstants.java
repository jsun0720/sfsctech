package com.sfsctech.core.base.constants;

/**
 * Class CommonConstants
 *
 * @author 张麒 2016/5/25.
 * @version Description:
 */
public class CommonConstants {

    // Web
    //-------------------------------------------------------------------------------------------
    /**
     * Ajax请求表头
     */
    public static final String AJAX_ACCEPT_CONTENT_TYPE[] = {"Accept", "text/html;type=ajax"};
    public static final String AJAX_HEADER_CONTENT_TYPE[] = {"x-requested-with", "XMLHttpRequest"};
    /**
     * Ajax请求时间戳
     */
    public static final String AJAX_TIME_FRESH = "ajaxTimeFresh";

    public static final String VIEW_404 = "common/404";
    public static final String VIEW_500 = "common/500";

    // Common Attribute
    //-------------------------------------------------------------------------------------------
    public static final String SUCCESS = "success";
    public static final String MESSAGES = "messages";
    public static final String MESSAGES_DETAILS = "messages_details";


    // Startup Parameters Attribute
    //-------------------------------------------------------------------------------------------
    /**
     * 国际化文件路径
     */
    public static final String[] RESOURCES_I18N_PATH = {"i18n/defaultMessages", "i18n/messages"};

    // Front UI Attribute
    //-------------------------------------------------------------------------------------------
    /**
     * 静态资源地址
     */
    public static final String STATIC_RESOURCE_ATTRIBUTE = "static_resource";

    /**
     * 项目ContextPath
     */
    public static final String CONTEXT_PATH_ATTRIBUTE = "context_path";

    /**
     * 网站域名
     */
    public static final String WEBSITE_DOMAIN_ATTRIBUTE = "website_domain";

    // Logback Setting Attribute
    //-------------------------------------------------------------------------------------------
    /**
     * 配置文件地址
     */
    public static final String LOGBACK_CONFIG_FILE_LOCATION_PARAM = "logback-config-location";

    /**
     * 是否显示WebAppRoot
     */
    public static final String LOGBACK_EXPOSE_WEB_APP_ROOT_PARAM = "logback-expose-webapp-root";

    // Authentication Attribute
    //-------------------------------------------------------------------------------------------

}