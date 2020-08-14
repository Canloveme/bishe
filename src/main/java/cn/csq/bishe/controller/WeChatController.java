package cn.csq.bishe.controller;

import cn.csq.bishe.config.ProjectUrlConfig;
import cn.csq.bishe.enums.ResultEnum;
import cn.csq.bishe.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassName : WeChatController
 * @Author : CSQ
 * @Date: 2020-03-14 18:20
 * 微信接口控制
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1. 配置
        //2. 调用方法
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new MyException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
//        String openId = "oTgZpwezNoKuGiXQzYCg1Hvj3XuA";

        return "redirect:" + returnUrl + "?openid=" + openId;
    }



    @GetMapping("/qrAuthorize")
    public String qrauthorize(@RequestParam("returnUrl") String returnUrl)
            throws UnsupportedEncodingException {
        //1 配置
        //2 调用方法
        String url = projectUrlConfig.getWechatOpenAuthorize()+ "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url,
                WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN,//登录
                URLEncoder.encode(returnUrl,"utf-8"));
        return  "redirect:" + redirectUrl;
    }


    @GetMapping("/qrUserInfo")
    public String qruserInfo(@RequestParam("code") String code/*,
                           @RequestParam("state") String returnUrl*/) {
        log.info("code : " + code);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new MyException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        String returnUrl = "http://canloveme.mynatapp.cc/sell/seller/login";
        return "redirect:"+returnUrl+"?openId="+openId;
    }

}
