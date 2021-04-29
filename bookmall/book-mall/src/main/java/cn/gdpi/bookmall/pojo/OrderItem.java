package cn.gdpi.bookmall.pojo;

import cn.gdpi.bookmall.dto.CartBookDTO;

import java.io.Serializable;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-21 16:12
 *
***/
/**
    * 订单项目表
    */
public class OrderItem implements Serializable {
    /**
    * 记录编号
    */
    private Integer rid;

    /**
    * 商品（商品编号）
    */
    private String product;

    private CartBookDTO book;


    /**
    * 价格
    */
    private Double price;

    /**
    * 数量
    */
    private Integer count;

    /**
    * 订单编号
    */
    private String orderId;

    private BookImage image;

    public BookImage getImage() {
        return image;
    }

    public void setImage(BookImage image) {
        this.image = image;
    }

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CartBookDTO getBook() {
        return book;
    }

    public void setBook(CartBookDTO book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "rid=" + rid +
                ", product='" + product + '\'' +
                ", book=" + book +
                ", price=" + price +
                ", count=" + count +
                ", orderId='" + orderId + '\'' +
                ", image=" + image +
                '}';
    }
}