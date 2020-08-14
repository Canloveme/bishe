package cn.csq.bishe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ProjectUrl
 * @Author : CSQ
 * @Date: 2020-04-02 13:56
 * 项目使用url配置类
 */
@Data
@ConfigurationProperties(prefix = "projecturl")
@Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权URL
     */
    public String wechatMpAuthorize;


    /**
     * 微信开发平台授权URL
     */
    public String wechatOpenAuthorize;

    /**
     * 项目URl
     */
    public String sell;
}
