package cn.csq.bishe.aspect;

import cn.csq.bishe.constant.CookieConstant;
import cn.csq.bishe.constant.RedisConstant;
import cn.csq.bishe.exception.MyAuthorizeException;
import cn.csq.bishe.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//*
// * @ClassName : SellerAuthorizeAspect
// * @Author : CSQ
// * @Date: 2020-04-02 14:55
// * 卖家身份验证
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //验证方法 切入点
    @Pointcut("execution(public * cn.csq.bishe.controller.Seller*.*(..))" +
            "&& !execution(public * cn.csq.bishe.controller.SellerUserController.*(..))")
    public void verify() {}

    //方法实现
    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            //没有登录
            log.warn("【登录校验】Cookie中查不到token");
            throw new MyAuthorizeException();
        }
        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new MyAuthorizeException();
        }
    }
}

