package cn.csq.bishe.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : ProductForm
 * @Author : CSQ
 * @Date: 2020-04-01 17:39
 * 商品表单
 */
@Data
public class ProductForm {

    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;
}
