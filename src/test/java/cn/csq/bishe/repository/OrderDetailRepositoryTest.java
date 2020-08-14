package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("11112");
        orderDetail.setProductId("112423");
        orderDetail.setProductIcon("http://baidu.com");
        orderDetail.setProductName("原味奶茶");
        orderDetail.setProductPrice(new BigDecimal(3443));
        orderDetail.setProductQuantity(3);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId("11111");
        Assert.assertNotNull(orderDetails);
    }
}