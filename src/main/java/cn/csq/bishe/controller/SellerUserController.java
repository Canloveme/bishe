package cn.csq.bishe.controller;

import cn.csq.bishe.config.ProjectUrlConfig;
import cn.csq.bishe.constant.CookieConstant;
import cn.csq.bishe.constant.RedisConstant;
import cn.csq.bishe.dataobject.SellerInfo;
import cn.csq.bishe.enums.ResultEnum;
import cn.csq.bishe.service.SellerService;
import cn.csq.bishe.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : SellerUserController
 * @Author : CSQ
 * @Date: 2020-04-02 14:04
 * 卖家登录登出
 */
@Controller
@Slf4j
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openId") String openId,
                              Map<String, Object> map,
                              HttpServletResponse response) {
        //1.openid和数据库数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openId);
        if (sellerInfo == null) {
            map.put("message", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.设置token到redis
        String token = UUID.randomUUID().toString();
        //设置过期时间
        Integer expire = RedisConstant.EXPIRE;
        //以token_为前缀存储openId ，设置过期时间，以秒为单位  key，value，过期时间，时间单位秒
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openId, expire, TimeUnit.SECONDS);
        //3.设置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        //绝对地址
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");


    }

        @GetMapping("/logout")
        public ModelAndView logout(HttpServletRequest request,
                                   HttpServletResponse response,
                                   Map<String, Object> map) {
            //1. 从cookie里查询
            Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
            if (cookie != null) {
                //2. 清除redis
                stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

                //3. 清除cookie
                CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
            }

            map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/success", map);
        }

}
