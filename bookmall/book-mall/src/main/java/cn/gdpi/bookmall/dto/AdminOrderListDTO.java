package cn.gdpi.bookmall.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-22 13:10
 ***/
public class AdminOrderListDTO implements Serializable {
    private static final long serialVersionUID = -5614527663796643994L;

    /**
     * 订单编号（手机号后3位+yyyyMMddHHmm）
     */
    private String orderId;

    /**
     * 订单状态（待处理；处理中；已发货；已交付）
     */
    private String sta;



    /**
     * 支付金额
     */
    private Double payment;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date placed;

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

    @Override
    public String toString() {
        return "AdminOrderListDTO{" +
                "orderId='" + orderId + '\'' +
                ", sta='" + sta + '\'' +
                ", payment=" + payment +
                ", placed=" + placed +
                '}';
    }
}
