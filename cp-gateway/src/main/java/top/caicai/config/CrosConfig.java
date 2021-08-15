package top.caicai.config;

//import org.apache.catalina.filters.CorsFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CrosConfig {
    @Bean
    public CorsFilter corsFilter (){
        //添加cors信息
        CorsConfiguration config = new CorsConfiguration();
        //添加允许域
        config.addAllowedOrigin("http://api.caicai.top");
        config.addAllowedOrigin("http://manage.caicai.top");
        //是否发送cookie
        config.setAllowCredentials(true);
        //允许请求方式
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("DELETE");
        //允许信息头
        config.addAllowedHeader("*");

        //设置有效时长
        config.setMaxAge(3600L);
        //添加拦截映射路径
        UrlBasedCorsConfigurationSource ConfigurationSource = new UrlBasedCorsConfigurationSource();
        ConfigurationSource.registerCorsConfiguration("/**",config);

        return new CorsFilter(ConfigurationSource);


    }


}
