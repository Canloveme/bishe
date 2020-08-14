package cn.csq.bishe.enums;

import lombok.Getter;

/**
 * 异常信息枚举类
 *
 * @author MSI-PC
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    PARAM_ERROR(1, "参数不正确"),
    /**
     * 商品不存在错误
     * 错误码10 ，错误信息商品不存在
     */
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    /**
     * 库存不正确
     * 错误码11，错误信息 商品库存不正确
     */
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    /**
     * 订单不存在
     * 错误码 12，错误信息 订单不存在
     */
    ORDER_NOT_EXIST(12, "订单不存在"),
    /**
     * 订单详情不存在
     * 错误码 13 错误信息 订单详情不存在
     */
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    /**
     * 订单状态异常
     * 错误码 14 错误信息 订单状态异常
     */
    ORDERSTATUS_STATUS_ERROR(14, "订单状态异常"),

    ORDERSTATUS_UPDATE_FAIL(15, "订单状态更新失败"),

    ORDER_DETAIL_EMPTY(16, "订单详细为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),

    CART_EMPTY(18, "购物车不能为空"),

    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),

    WECHAT_MP_ERROR(20, "微信公众账户错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "微信支付异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),

    ORDER_FINISH_SUCCESS(23,"订单完结成功"),

    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),

    LOGIN_FAIL(25, "登录失败"),

    LOGOUT_SUCCESS(26, "登出成功"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
