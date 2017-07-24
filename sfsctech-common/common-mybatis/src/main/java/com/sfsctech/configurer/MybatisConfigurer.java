package com.sfsctech.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.fastjson.JSON;
import com.sfsctech.constants.LabelConstants;
import com.sfsctech.mybatis.datasource.ReadWriteDataSource;
import com.sfsctech.mybatis.datasource.aop.ReadWriteAdvice;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Class MybatisConfigurer
 *
 * @author 张麒 2017/5/25.
 * @version Description:
 */
@Configuration
@MapperScan("com.sfsctech.*.mapper")
public class MybatisConfigurer {

    @Bean()
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource masterDatasource() {
        return new DruidDataSource();
    }

    @Bean()
    @ConfigurationProperties(prefix = "spring.slaveDatasource")
    public Map<String, Map<String, Object>> slaveDatasource() {
        return new HashMap<>();
    }

    @Bean()
    public DataSource dynamicDatasource() {
        ReadWriteDataSource dataSource = new ReadWriteDataSource();
        dataSource.setWriteDataSource(masterDatasource());
        Map<String, Map<String, Object>> slaves = slaveDatasource();
        Map<String, DruidDataSource> slaveMap = new HashMap<>();
        slaves.forEach((key, value) -> slaveMap.put(key, JSON.parseObject(JSON.toJSONString(value), DruidDataSource.class)));
        dataSource.setReadDataSources(slaveMap);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDatasource());
        // 指定xml文件位置
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/config/ibatis/*/*.xml"));
        return factoryBean.getObject();
    }

    /**
     * 定义通知实现类
     *
     * @return ReadWriteAdvice
     */
    @Bean
    public ReadWriteAdvice readWriteAdvice() {
        return new ReadWriteAdvice();
    }

//    /**
//     * 定义通过名称匹配的切面
//     *
//     * @return NameMatchMethodPointcutAdvisor
//     */
//    @Bean
//    public NameMatchMethodPointcutAdvisor readWriteAdvisor() {
//        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
//        advisor.setAdvice(readWriteAdvice());
//        advisor.setMappedName("*");
//        return advisor;
//    }

    /**
     * 定义切点（类配置了com.sfsctech.mybatis.annotation.DataSource注解）
     *
     * @return AnnotationMatchingPointcut
     */
    @Bean
    public AnnotationMatchingPointcut annotationMatchingPointcut() {
        return new AnnotationMatchingPointcut(com.sfsctech.mybatis.annotation.DataSource.class);
    }

    /**
     * 定义默认切点通知
     *
     * @return DefaultPointcutAdvisor
     */
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(annotationMatchingPointcut());
        advisor.setAdvice(readWriteAdvice());
        return advisor;
    }

    /**
     * 定义代理
     *
     * @return BeanNameAutoProxyCreator
     */
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        // 需要增强的类
        autoProxyCreator.setBeanNames("*ServiceImpl");
        // 设置通知
        autoProxyCreator.setInterceptorNames("defaultPointcutAdvisor");
        return autoProxyCreator;
    }

    /**
     * druid注册一个StatViewServlet
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServlet() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册WebStatFilter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean druidWebStatFilter = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        druidWebStatFilter.addUrlPatterns(LabelConstants.FORWARD_SLASH + LabelConstants.STAR);
        //添加不需要忽略的格式信息.
        druidWebStatFilter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return druidWebStatFilter;
    }
}
