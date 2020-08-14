package cn.csq.bishe.service.impl;

import cn.csq.bishe.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;

    public static final String OPENID = "abc123";

    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo result = sellerService.findSellerInfoByOpenId(OPENID);
        Assert.assertEquals(OPENID, result.getOpenId());
    }
}