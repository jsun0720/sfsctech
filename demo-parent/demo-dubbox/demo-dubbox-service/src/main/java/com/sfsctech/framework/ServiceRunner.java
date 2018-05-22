package com.sfsctech.framework;

import com.sfsctech.dubbo.starter.annotation.EnableDubboProviderService;
import org.springframework.boot.SpringApplication;

/**
 * Class ServiceRunning
 *
 * @author 张麒 2017/5/26.
 * @version Description:
 */
@EnableDubboProviderService
public class ServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRunner.class, args);
    }
}
