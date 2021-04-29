package cn.gdpi.bookmall.controller.admin;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.pojo.Order;
import cn.gdpi.bookmall.service.IOrderService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:32
 ***/
@RestController
@RequestMapping("/admin/order")
@CrossOrigin
public class AdminOrderController {

    @Resource
    private IOrderService iOrderService;

    @Intercept(role = 1)
    @GetMapping("/list/{page}/{limit}")
    public Return list(@RequestParam(required = false) String sta,@PathVariable int page, @PathVariable int limit){
        return iOrderService.adminOrderAll(sta,page,limit);
    }

    @Intercept(role = 1)
    @PostMapping("updateOrderSta")
    public Return updateOrderSta(@RequestBody Order order){

        return iOrderService.updateOrderSta(order);
    }

    @Intercept(role = 1)
    @GetMapping("/orderInfo/{orderId}")
    public Return orderInfo(@PathVariable String orderId){
        return iOrderService.orderInfo(orderId,null);
    }
}
