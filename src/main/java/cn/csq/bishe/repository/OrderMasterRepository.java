package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品dao
 * @ClassName : OrderMasterRes
 * @Author : CSQ
 * @Date: 2020-03-12 20:08
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家的微信openId查找订单并分页
     * @param buyerOpenid 买家openid
     * @param pageable 分页
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
