package cn.csq.bishe.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author MSI-PC
 */

@Getter
public enum ProductStatusEnum implements CodeEnum {
    /**
     * 商品状态 0 ，上架
     */
    UP(0, "上架状态"),
    /**
     * 商品状态  1， 下架
     */
    DOWN(1,"下架状态"),
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
