package cn.csq.bishe.constant;

/**
 * @ClassName : RedisConstant
 * @Author : CSQ
 * @Date: 2020-04-02 14:30
 * redis常量
 */
public interface RedisConstant {

    //前缀
    String TOKEN_PREFIX = "token_%s";

    //token过期时间 两个小时
    Integer EXPIRE = 7200;
}
