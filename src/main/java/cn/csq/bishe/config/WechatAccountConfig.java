package cn.csq.bishe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName : WechatAccountConfig
 * @Author : CSQ
 * @Date: 2020-03-14 18:33
 * 微信配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台id
     */
    private String mpAppId;

    /**
     * 公众平台密钥
     */
    private String mpAppSecret;

    /**
     * 开放平台id
     */
    private String openAppId;
    /**
     * 开放平台密钥
     */
    private String openAppSecret;

    /**商户号*/
    private String mchId;

    /**商户密钥*/
    private String mchKey;

    /**商户证书路径*/
    private String KeyPath;



    /**商户支付异步通知*/
    private String notifyUrl;

    /**
     * 微信模版id
     */
    private Map<String, String> templateId;


}
