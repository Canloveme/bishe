package cn.csq.bishe.converter;

import cn.csq.bishe.dataobject.OrderDetail;
import cn.csq.bishe.dto.OrderDTO;
import cn.csq.bishe.enums.ResultEnum;
import cn.csq.bishe.exception.MyException;
import cn.csq.bishe.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.GsonJsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : OrderForm2OrderDTOConverter
 * @Author : CSQ
 * @Date: 2020-03-14 14:42
 * orderForm 对象 转化为 orderDTO
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new MyException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}