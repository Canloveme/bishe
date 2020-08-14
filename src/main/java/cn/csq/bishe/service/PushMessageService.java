package cn.csq.bishe.service;

import cn.csq.bishe.dto.OrderDTO;

/**
 * 推送消息
 * @author MSI-PC
 */
public interface PushMessageService {


    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
