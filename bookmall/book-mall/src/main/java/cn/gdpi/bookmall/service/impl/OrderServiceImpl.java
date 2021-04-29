package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.dto.AdminOrderListDTO;
import cn.gdpi.bookmall.dto.ClientOrderListDTO;
import cn.gdpi.bookmall.mapper.OrderMapper;
import cn.gdpi.bookmall.pojo.Order;
import cn.gdpi.bookmall.service.IOrderService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.Dictionary;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-21 16:17
 ***/
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private OrderMapper orderMapper;


    @Override
    public Return createOrder(Order order, String token) {
        if(order.getOrderItems().size()<=0){
            return Return.error(Code.ERROR_CODE,"请选择书籍");
        }
        Date date=new Date();
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
        String dateStr=format.format(date);
        String orderId= phone.substring(8)+dateStr;
        order.setOrderId(orderId);
        order.setUserId(phone);
        order.setPlaced(date);
        order.setSta(Dictionary.ORDER_PENDING);
        int n=orderMapper.insertOrder(order);
        int m=orderMapper.insertOrderItems(order.getOrderItems(),orderId);
        if(n!=1||m<=0){
            return Return.error(Code.ERROR_CODE,"创建订单失败！");
        }
        return Return.ok(Code.OK_CODE,orderId,"创建订单成功！");
    }

    @Override
    public Return orderInfo(String orderId, String token) {
        String phone = jwtTokenUtil.getPhoneFromToken(token);
        Order order= orderMapper.selectOrderOne(orderId,phone);
        return Return.ok(Code.OK_CODE,order);
    }

    @Override
    public Return pay(String orderId, String token) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setSta(Dictionary.ORDER_BEING_PROCESSED);
        order.setReceipt(new Date());
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        int n=orderMapper.updateOrder(order,phone);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"支付失败");
        }
        return Return.ok(Code.OK_CODE,"支付成功");
    }

    @Override
    public Return confirmOrder(Order order,String token) {
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        int n=orderMapper.updateOrder(order,phone);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"确认订单失败");
        }
        return Return.ok(Code.OK_CODE,"确认订单成功");
    }

    @Override
    public Return adminOrderAll(String sta,int page,int limit) {
        PageHelper.startPage(page,limit);
        List<AdminOrderListDTO> list= orderMapper.selectAdminOrderListDTOList(sta);
        PageInfo<AdminOrderListDTO> pageInfo=new PageInfo<>(list);
        return Return.ok(Code.OK_CODE,pageInfo);
    }

    @Override
    public Return updateOrderSta(Order order) {
        order.setDeliver(new Date());
        int n=orderMapper.updateOrder(order,null);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"修改失败");
        }
        return Return.ok(Code.OK_CODE,"修改成功");
    }

    @Override
    public Return clientOrderList(String token, int page, int limit) {
        PageHelper.startPage(page,limit);
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        List<ClientOrderListDTO> list= orderMapper.selectOrderList(phone);
        PageInfo<ClientOrderListDTO> pageInfo=new PageInfo<>(list);
        return Return.ok(Code.OK_CODE,pageInfo);
    }

    @Override
    public Return receiving(String orderId, String token) {
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        Order order=new Order();
        order.setSta(Dictionary.ORDER_DELIVERED);
        order.setHandover(new Date());
        order.setOrderId(orderId);
        int n=orderMapper.updateOrder(order,phone);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"收货失败");
        }
        return Return.ok(Code.OK_CODE,"收货成功");
    }
}
