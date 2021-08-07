package top.caicai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy//开启网关
@SpringBootApplication //springbooot 应用
public class gatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(gatewayApplication.class);
    }

}
