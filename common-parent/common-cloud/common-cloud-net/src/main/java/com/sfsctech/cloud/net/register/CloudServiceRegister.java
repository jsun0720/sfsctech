//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sfsctech.cloud.net.register;

import com.sfsctech.cloud.net.starter.EnableCloudController;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 接口注册
 */
public class CloudServiceRegister implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    private static final Class SCAN_ANNOTATION_CLASS = EnableCloudController.class;
    private static final String BASE_PACKAGES_KEY = "packages";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (annotationMetadata.hasAnnotation(SCAN_ANNOTATION_CLASS.getName())) {
            String[] basePackages = (String[]) annotationMetadata.getAnnotationAttributes(SCAN_ANNOTATION_CLASS.getName()).get(BASE_PACKAGES_KEY);
            CloudServiceScanner commonNetApiScanner = new CloudServiceScanner(beanDefinitionRegistry);
            if (this.resourceLoader != null) commonNetApiScanner.setResourceLoader(this.resourceLoader);
            commonNetApiScanner.registerIncludeFilters();
            commonNetApiScanner.doScan(basePackages);
        }
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
