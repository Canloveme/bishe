package cn.csq.bishe.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 根据http请求api返回的视图对象
 * @ClassName : ResultVo
 * @Author : CSQ
 * @Date: 2020-03-11 14:04
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;


}
