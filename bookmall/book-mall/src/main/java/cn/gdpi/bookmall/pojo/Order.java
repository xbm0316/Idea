package cn.gdpi.bookmall.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单信息表
 *@author lihaotao
 *@description 说明
 *@date 2020-12-21 16:13
 *
***/
public class Order implements Serializable {
    /**
    * 记录编号
    */
    private Integer rid;

    /**
    * 用户编号（用户手机号）
    */
    private String userId;

    /**
    * 订单编号（手机号后3位+yyyyMMddHHmm）
    */
    private String orderId;

    /**
    * 订单状态（待处理；处理中；已发货；已交付）
    */
    private String sta;

    /**
    * 收货地址
    */
    private Integer addressId;

    /**
    * 支付金额
    */
    private Double payment;

    /**
    * 下单时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date placed;

    /**
    * 接单时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date receipt;

    /**
    * 发货时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date deliver;

    /**
    * 交付时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date handover;

    private List<OrderItem> orderItems;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Date getPlaced() {
        return placed;
    }

    public void setPlaced(Date placed) {
        this.placed = placed;
    }

    public Date getReceipt() {
        return receipt;
    }

    public void setReceipt(Date receipt) {
        this.receipt = receipt;
    }

    public Date getDeliver() {
        return deliver;
    }

    public void setDeliver(Date deliver) {
        this.deliver = deliver;
    }

    public Date getHandover() {
        return handover;
    }

    public void setHandover(Date handover) {
        this.handover = handover;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "rid=" + rid +
                ", userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", sta='" + sta + '\'' +
                ", addressId=" + addressId +
                ", payment=" + payment +
                ", placed=" + placed +
                ", receipt=" + receipt +
                ", deliver=" + deliver +
                ", handover=" + handover +
                ", orderItems=" + orderItems +
                ", address=" + address +
                '}';
    }
}