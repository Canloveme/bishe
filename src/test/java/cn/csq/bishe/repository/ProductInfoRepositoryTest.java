package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1233");
        productInfo.setProductName("特浓咖啡");
        productInfo.setProductPrice(new BigDecimal(8));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("很浓很苦的咖啡");
        productInfo.setProductIcon("http:www.baidu.com.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        //查询所有上架的商品
        List<ProductInfo> ProductList = productInfoRepository.findByProductStatus(0);
        Assert.assertEquals(3, ProductList.size());
    }
}