package com.ihrm.audit;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.common.utils.JwtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

//1.配置springboot的包扫描
@SpringBootApplication(scanBasePackages = "com.ihrm",exclude ={ SecurityAutoConfiguration.class} )
//2.配置jpa注解的扫描
@EntityScan(value="com.ihrm.domain")
//3.注册到eureka
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class AuditApplication {

    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class,args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
