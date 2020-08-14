package cn.csq.bishe.repository;

import cn.csq.bishe.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : SellerInfoRepository
 * @Author : CSQ
 * @Date: 2020-04-02 13:19
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    /**
     * 根据openId查找用户信息
     * @param openId
     * @return
     */
    SellerInfo findByOpenId(String openId);
}
