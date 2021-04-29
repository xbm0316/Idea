package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.dto.AdminOrderListDTO;
import cn.gdpi.bookmall.dto.ClientOrderListDTO;
import cn.gdpi.bookmall.pojo.Order;
import cn.gdpi.bookmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-21 16:13
 *
***/
public interface OrderMapper {

    /**
     * 创建订单
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 创建订单项
     * @param orderItems
     * @return
     */
    int insertOrderItems(@Param("orderItems") List<OrderItem> orderItems,@Param("orderId") String orderId);

    Order selectOrderOne(@Param("orderId") String orderId,@Param("phone") String phone);

    int updateOrder(@Param("order") Order order,@Param("phone") String phone);

    List<AdminOrderListDTO> selectAdminOrderListDTOList(@Param("sta") String sta);


    List<ClientOrderListDTO> selectOrderList(String phone);
}