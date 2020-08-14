package cn.csq.bishe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName : UpYunConfig
 * @Author : CSQ
 * @Date: 2020-04-27 13:29
 * 又拍云配置
 */
@Component
@ConfigurationProperties("upyun")
@Data
public class UpYunConfig {

    private String bucketName;

    private String username;

    private String password;

    /**
     * http://xxx.com/
     */
    private String imageHost;
}
