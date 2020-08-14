package cn.csq.bishe.service;

import cn.csq.bishe.dataobject.SellerInfo;

/**
 * @author MSI-PC
 */
public interface SellerService {

    /**
     * 根据卖家openId查询卖家信息
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openId);


}
