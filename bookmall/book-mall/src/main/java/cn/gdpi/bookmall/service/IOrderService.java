package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.pojo.Order;
import cn.gdpi.bookmall.util.Return;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-21 16:17
 ***/
public interface IOrderService {
    /**
     * 创建订单
     * @param order
     * @param token
     * @return
     */
    Return createOrder(Order order, String token);

    /**
     * 订单详情
     * @param orderId
     * @param token
     * @return
     */
    Return orderInfo(String orderId, String token);

    /**
     * 支付
     * @param orderId
     * @param token
     * @return
     */
    Return pay(String orderId, String token);

    /**
     * 确认订单
     * @param order
     * @param token
     * @return
     */
    Return confirmOrder(Order order,String token);

    /**
     * 所有用户的订单
     * @return
     */
    Return adminOrderAll(String sta,int page,int limit);

    /**
     * 修改订单状态
     * @param order
     * @param token
     * @return
     */
    Return updateOrderSta(Order order);

    /**
     * yhu
     * @param token
     * @param page
     * @param limit
     * @return
     */
    Return clientOrderList(String token, int page, int limit);

    /**
     * 收货
     * @param orderId
     * @param token
     * @return
     */
    Return receiving(String orderId, String token);
}
