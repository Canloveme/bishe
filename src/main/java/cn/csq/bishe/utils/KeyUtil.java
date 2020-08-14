package cn.csq.bishe.utils;

import java.util.Random;

/**
 * 生成随机数的工具类
 *
 * @ClassName : KeyUtil
 * @Author : CSQ
 * @Date: 2020-03-13 16:58
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式： 时间+随机数
     * synchronized 保证多线程安全
     * @return 唯一主键
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        //生成六位随机数
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
