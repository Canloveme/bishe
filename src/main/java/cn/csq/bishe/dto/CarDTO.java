package cn.csq.bishe.dto;

import lombok.Data;
import lombok.Getter;

/**
 * 购物车对象
 *
 * @ClassName : CarDTO
 * @Author : CSQ
 * @Date: 2020-03-13 17:14
 */
@Data
@Getter
public class CarDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

