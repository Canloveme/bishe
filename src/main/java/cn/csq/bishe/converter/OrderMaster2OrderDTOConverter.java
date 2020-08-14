package cn.csq.bishe.converter;

import cn.csq.bishe.dataobject.OrderMaster;
import cn.csq.bishe.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : OrderMaster2OrderDTOConverter
 * @Author : CSQ
 * @Date: 2020-03-13 19:34
 * OrderMaster 转成OrderDTO
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}