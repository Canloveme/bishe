package cn.csq.bishe.utils;

import cn.csq.bishe.enums.CodeEnum;

/**
 * @ClassName : EnumUtil
 * @Author : CSQ
 * @Date: 2020-04-01 13:43
 * 枚举工具类
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        //如果code值相等就返回这个枚举
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
