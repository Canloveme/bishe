package cn.csq.bishe.service;

import cn.csq.bishe.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目服务
 * @author MSI-PC
 */
public interface ProductCategoryService {

    /**
     * 根据商品类别id查询一条记录  后台管理
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有商品类别  后台管理
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据商品的类别编号查找对应的所有商品类别   买家端
     * @param categoryTypeList 商品类别列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存/修改商品类别  后台管理
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
