package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryRepository.getOne(1);
        Assert.assertNotNull(productCategory);
        System.out.println(productCategory);
    }

    @Test
//    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(1);
        productCategoryRepository.save(productCategory);
        Assert.assertNotEquals(null,productCategory);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = productCategoryRepository.getOne(3);
        productCategory.setCategoryType(4);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> list1 = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,list.size());
        System.out.println(list1);
    }
}