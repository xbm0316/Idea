package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.pojo.Order;
import cn.gdpi.bookmall.service.IOrderService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:24
 ***/
@RequestMapping("/client/order")
@RestController
public class ClientOrderController {

    @Resource
    private IOrderService iOrderService;

    /**
     * 订单列表
     * @param page
     * @param limit
     * @param token
     * @return
     */
    @GetMapping("/orderList/{page}/{limit}")
    @Intercept
    public Return orderList(@PathVariable int page,@PathVariable int limit,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.clientOrderList(token,page,limit);
    }

    /**
     * 订单详情
     * @param orderId
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/orderInfo/{orderId}")
    public Return orderInfo(@PathVariable String orderId,@RequestHeader(value = "Authorization",required = false) String token){

        return iOrderService.orderInfo(orderId,token);
    }

    /**
     * 创建订单
     * @param order
     * @param token
     * @return
     */
    @Intercept
    @PostMapping("/createOrder")
    public Return createOrder(@RequestBody Order order,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.createOrder(order,token);
    }

    /**
     * 立即购买
     * @param order
     * @param token
     * @return
     */
    @Intercept
    @PostMapping("/immediatelyBuy")
    public Return immediatelyBuy(@RequestBody Order order,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.createOrder(order,token);
    }

    /**
     * 支付
     * @param orderId
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/pay/{orderId}")
    public Return pay(@PathVariable String orderId,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.pay(orderId,token);
    }

    /**
     * 确认订单
     * @param order
     * @param token
     * @return
     */
    @Intercept
    @PostMapping("/confirmOrder")
    public Return confirmOrder(@RequestBody Order order,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.confirmOrder(order,token);
    }

    /**
     * 收货
     * @return
     */
    @Intercept
    @GetMapping("/receiving/{orderId}")
    public Return receiving(@PathVariable String orderId,@RequestHeader(value = "Authorization",required = false) String token){
        return iOrderService.receiving(orderId,token);
    }

}
