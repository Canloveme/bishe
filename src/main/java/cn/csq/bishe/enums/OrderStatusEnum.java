package cn.csq.bishe.enums;

import lombok.Getter;

/**
 * 订单状态
 *
 * @author MSI-PC
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    /**
     * 新订单
     */
    NEW(0, "新订单"),
    /**
     * 订单已经完结
     */
    FINISHED(1, "完结"),
    /**
     * 订单已取消
     */
    CANCEL(2, "已取消"),
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
