package cn.csq.bishe.service;

import cn.csq.bishe.dataobject.OrderMaster;
import cn.csq.bishe.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单服务
 *
 * @ClassName : OrderService
 * @Author : CSQ
 * @Date: 2020-03-13 16:30
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO 订单
     * @return 创建的订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询某个订单
     * @param orderId 订单id
     * @return 订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 分页查询订单列表
     * @param buyerOpenId 订单id
     * @param pageable 分页对象
     * @return 分页的订单列表对象
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     * @param orderDTO 订单对象
     * @return 结果
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO 订单对象
     * @return 结果
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO 订单对象
     * @return 结果
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 分页查询所有订单列表
     * @param pageable 分页对象
     * @return 分页的订单列表对象
     */
    Page<OrderDTO> findList(Pageable pageable);
}
