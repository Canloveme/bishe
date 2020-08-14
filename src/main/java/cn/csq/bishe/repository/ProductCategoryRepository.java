package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author csq
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     *根据商品类别编号查询商品类别
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
