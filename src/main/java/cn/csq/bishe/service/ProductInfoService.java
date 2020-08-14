package cn.csq.bishe.service;

import cn.csq.bishe.dataobject.ProductCategory;
import cn.csq.bishe.dataobject.ProductInfo;
import cn.csq.bishe.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品服务
 * @author MSI-PC
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);
    /**
     * 查询所有在架商品  前台
     * @return 在架商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品  后端
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存/修改
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 添加库存
     */
    void increaseStock(List<CarDTO> carDTOList);

    /**
     * 减库存
     * @param carDTOList 购物车对象列表
     */
    void decreaseStock(List<CarDTO> carDTOList);

    /**
     * 上架
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);
}
