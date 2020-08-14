package cn.csq.bishe.service.impl;

import cn.csq.bishe.dataobject.SellerInfo;
import cn.csq.bishe.repository.SellerInfoRepository;
import cn.csq.bishe.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : SellerServiceImpl
 * @Author : CSQ
 * @Date: 2020-04-02 13:32
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return sellerInfoRepository.findByOpenId(openId);
    }

}
