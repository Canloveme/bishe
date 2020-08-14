package cn.csq.bishe.enums;

import lombok.Getter;

/**
 * 支付状态
 *
 * @author MSI-PC
 */
@Getter
    public enum PayStatusEnum implements  CodeEnum {
    /**
     * 等待买家支付
     */
    WAIT(0, "等待支付"),
    /**
     * 买家支付成功
     */
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
