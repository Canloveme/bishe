package cn.csq.bishe.service.impl;

import cn.csq.bishe.dto.OrderDTO;
import cn.csq.bishe.enums.ResultEnum;
import cn.csq.bishe.exception.MyException;
import cn.csq.bishe.service.BuyerService;
import cn.csq.bishe.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : BuyerServiceImpl
 * @Author : CSQ
 * @Date: 2020-03-14 16:41
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查询不到该订单，openid={}", openid);
            throw new MyException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    /**
     * 判断是否是当前用户的订单
     * @param openid 买家微信openid
     * @param orderId 订单id
     * @return 是否为当前订单的用户
     */
    public OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否为自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={},orderDTO={}", openid, orderDTO);
            throw new MyException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
