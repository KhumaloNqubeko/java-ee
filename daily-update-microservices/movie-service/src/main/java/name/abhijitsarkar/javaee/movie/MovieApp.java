package name.abhijitsarkar.javaee.movie;

import name.abhijitsarkar.javaee.auth.HttpSecurityConfig;
import name.abhijitsarkar.javaee.common.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Abhijit Sarkar
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {MovieApp.class, CommonConfig.class, HttpSecurityConfig.class})
@EnableFeignClients
@EnableDiscoveryClient
public class MovieApp {
    public static void main(String[] args) {
        SpringApplication.run(MovieApp.class, args);
    }
}
