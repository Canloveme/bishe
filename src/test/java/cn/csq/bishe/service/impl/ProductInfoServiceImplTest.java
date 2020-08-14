package cn.csq.bishe.service.impl;

import cn.csq.bishe.dataobject.ProductInfo;
import cn.csq.bishe.enums.ProductStatusEnum;
import cn.csq.bishe.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private  ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productInfoService.findUpAll();
        Assert.assertNotEquals(0, upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("234123");

    }

    @Test
    public void onSale() {
        ProductInfo result = productInfoService.onSale("123");
        Assert.assertNotEquals(ProductStatusEnum.UP, result.getProductStatusEnum().getCode());
    }

    @Test
    public void offSale() {
        ProductInfo result = productInfoService.offSale("123");
        Assert.assertNotEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum().getCode());
    }
}