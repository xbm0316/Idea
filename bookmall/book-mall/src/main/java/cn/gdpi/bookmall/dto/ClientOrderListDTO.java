package cn.gdpi.bookmall.dto;

import cn.gdpi.bookmall.pojo.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-22 16:47
 ***/
public class ClientOrderListDTO implements Serializable {
    private static final long serialVersionUID = -8182138733206675955L;

    private String orderId;

    /**
     * 订单状态（待处理；处理中；已发货；已交付）
     */
    private String sta;

    /**
     * 接单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date receipt;

    private List<OrderItem> orderItems;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public Date getReceipt() {
        return receipt;
    }

    public void setReceipt(Date receipt) {
        this.receipt = receipt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "ClientOrderListDTO{" +
                "orderId='" + orderId + '\'' +
                ", sta='" + sta + '\'' +
                ", receipt=" + receipt +
                ", orderItems=" + orderItems +
                '}';
    }
}
