package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情dao
 * @author MSI-PC
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查询订单详情
     * @param orderId 订单id
     * @return 订单详情
     */
    List<OrderDetail> findByOrderId(String orderId);

}
