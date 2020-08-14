package cn.csq.bishe.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 * @ClassName : ProductCategory
 * @Author : CSQ
 * @Date: 2020-03-10 21:06
 */
@Entity
@DynamicUpdate//数据库数据修改，动态更新对应时间戳，自动更新时间
@Data
public class ProductCategory {

    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public ProductCategory() {
    }



}
