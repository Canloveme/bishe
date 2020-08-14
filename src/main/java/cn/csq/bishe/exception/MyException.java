package cn.csq.bishe.exception;

import cn.csq.bishe.enums.ResultEnum;
import lombok.Getter;

/**
 * @ClassName : MyException
 * @Author : CSQ
 * @Date: 2020-03-13 16:48
 */
@Getter
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
