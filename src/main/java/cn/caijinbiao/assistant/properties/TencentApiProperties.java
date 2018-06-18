package cn.caijinbiao.assistant.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:config/tencent-api.properties")
public class TencentApiProperties {
    @Value("${secretId}")
    private String secretId;
    @Value("${secret_key}")
    private String secretKey;
    @Value("${region}")
    private String region;
    @Value("${source}")
    private String source;
    @Value("${target}")
    private String target;
    @Value("${scene}")
    private String scene;
}
