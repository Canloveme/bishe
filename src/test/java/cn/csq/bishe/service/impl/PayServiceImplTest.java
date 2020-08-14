package cn.csq.bishe.service.impl;

import cn.csq.bishe.dto.OrderDTO;
import cn.csq.bishe.service.OrderService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {



    @Autowired
    private PayServiceImpl payService;
    @Autowired
    private OrderService orderService;


    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1584093478010631389");
        payService.create(orderDTO);

    }
}