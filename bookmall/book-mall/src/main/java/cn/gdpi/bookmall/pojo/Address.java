package cn.gdpi.bookmall.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址表
 *@author lihaotao
 *@description 说明
 *@date 2020-12-18 20:23
 *
***/
public class Address implements Serializable {
    /**
    * 记录编号
    */
    private Integer rid;

    /**
    * 用户编号（用户手机号）
    */
    private String userId;

    /**
    * 地址
    */
    private String address;

    /**
    * 添加日期/时间
    */
    private Date added;

    /**
    * 收件人（姓名）
    */
    private String receiver;

    /**
    * 收件人电话
    */
    private String receiverPhone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "rid=" + rid +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", added=" + added +
                ", receiver='" + receiver + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                '}';
    }
}