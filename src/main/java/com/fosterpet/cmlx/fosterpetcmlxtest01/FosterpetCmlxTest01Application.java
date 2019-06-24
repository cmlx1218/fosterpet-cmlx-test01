package com.fosterpet.cmlx.fosterpetcmlxtest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = {"com.fosterpet.cmlx"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.fosterpet.cmlx"})
@EnableCircuitBreaker
@EnableHystrixDashboard
public class FosterpetCmlxTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(FosterpetCmlxTest01Application.class, args);
    }

}
