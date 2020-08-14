package cn.csq.bishe.service;

import cn.csq.bishe.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author MSI-PC
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);


    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
