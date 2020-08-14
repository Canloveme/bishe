package cn.csq.bishe.utils;

import cn.csq.bishe.VO.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ResultVO对象操作工具类
 * @ClassName : ResultVOUtil
 * @Author : CSQ
 * @Date: 2020-03-11 15:05
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
