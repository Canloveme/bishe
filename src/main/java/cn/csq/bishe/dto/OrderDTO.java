package cn.csq.bishe.dto;

import cn.csq.bishe.dataobject.OrderDetail;
import cn.csq.bishe.enums.OrderStatusEnum;
import cn.csq.bishe.enums.PayStatusEnum;
import cn.csq.bishe.utils.EnumUtil;
import cn.csq.bishe.utils.serializer.Data2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Transient;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象 订单
 *
 * @ClassName : OderDTO
 * @Author : CSQ
 * @Date: 2020-03-13 16:35
 */
@Data
@Getter
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家OpendId
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态,默认等待支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date updateTime;

    /**
     * 订单详细信息列表
     */
     List<OrderDetail> orderDetailList;


     //对象转为json格式忽略这个
     @JsonIgnore
     //根据code返回枚举
    public OrderStatusEnum getOrderStatusEnum() {
        //return OrderStatusEnum.getOrderStatus(orderStatus);
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);

    }
}
