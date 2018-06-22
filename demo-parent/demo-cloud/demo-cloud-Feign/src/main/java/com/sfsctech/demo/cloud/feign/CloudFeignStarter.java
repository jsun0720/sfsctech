package com.sfsctech.demo.cloud.feign;

import com.sfsctech.cloud.net.starter.EnableCloudController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Class Star
 *
 * @author 张麒 2018-4-28.
 * @version Description:
 */
@EnableCloudController(packages = {"com.sfsctech.demo.*.inf.service"})
public class CloudFeignStarter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudFeignStarter.class).web(true).run(args);
    }
}
