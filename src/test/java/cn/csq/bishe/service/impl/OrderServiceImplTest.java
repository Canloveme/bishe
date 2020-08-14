package cn.csq.bishe.service.impl;

import cn.csq.bishe.dataobject.OrderDetail;
import cn.csq.bishe.dto.CarDTO;
import cn.csq.bishe.dto.OrderDTO;
import cn.csq.bishe.enums.OrderStatusEnum;
import cn.csq.bishe.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    public static final String BUYER_OPENID = "10010";
    public static final String ORDER_ID = "1584093478010631389";

    @Test
    public void creat() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("程山清");
        orderDTO.setBuyerPhone("15549457712");
        orderDTO.setBuyerAddress("地址太离谱");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        //奶茶2杯、咖啡3杯
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123");
        orderDetail1.setProductQuantity(2);
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("1233");
        orderDetail2.setProductQuantity(3);
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        System.out.println(orderDTO);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(1, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL,result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.FINISHED,result.getOrderStatus());
    }


    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertNotEquals(PayStatusEnum.SUCCESS, result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }
}