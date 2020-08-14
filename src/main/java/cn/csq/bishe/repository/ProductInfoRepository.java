package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author csq
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品上下架状态查询商品
     * @param productStatus 商品状态
     * @return 商品
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
