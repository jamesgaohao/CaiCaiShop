package top.caicai;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //开启网关
@SpringCloudApplication //springbooot 应用
public class gatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(gatewayApplication.class);
    }

}
