package top.caicai.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
@Data
@ConfigurationProperties(prefix = "cp.upload")
public class UploadProperties {
    private  String baseUrl;
    private List <String> allowType;

}
