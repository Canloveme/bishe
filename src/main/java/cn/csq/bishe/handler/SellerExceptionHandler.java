package cn.csq.bishe.handler;

import cn.csq.bishe.VO.ResultVO;
import cn.csq.bishe.config.ProjectUrlConfig;
import cn.csq.bishe.exception.MyAuthorizeException;
import cn.csq.bishe.exception.MyException;
import cn.csq.bishe.exception.ResponseBankException;
import cn.csq.bishe.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName : ExceptionHandler
 * @Author : CSQ
 * @Date: 2020-04-02 15:00
 * 异常捕获
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://canloveme.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://canloveme.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = MyAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResultVO handlerSellerException(MyException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException() {

    }

}
