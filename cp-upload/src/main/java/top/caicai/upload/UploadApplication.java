package top.caicai.upload;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"top.caicai"})
public class UploadApplication {

    public static void main(String[] args) {

        SpringApplication.run(UploadApplication.class);
    }

}
