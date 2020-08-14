package cn.csq.bishe.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName : SellerInfo
 * @Author : CSQ
 * @Date: 2020-04-02 13:17
 * 卖家信息表
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openId;

    private String createTime;

    private String updateTime;




}
