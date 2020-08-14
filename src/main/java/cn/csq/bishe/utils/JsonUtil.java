package cn.csq.bishe.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName : JsonUtil
 * @Author : CSQ
 * @Date: 2020-03-31 16:35
 * Json格式化的工具
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
