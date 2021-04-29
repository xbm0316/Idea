package cn.gdpi.bookmall.pojo;

import cn.gdpi.bookmall.dto.CartBookDTO;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 19:36
 ***/
public class CartItem implements Serializable {
    private static final long serialVersionUID = -8600516870805769511L;

    private Integer rid;
    private String userId;
    private CartBookDTO book;
    private String product;
    private Integer count;
    private BookImage image;

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

    public String getProduct() {
        return product;
    }

    public BookImage getImage() {
        return image;
    }

    public void setImage(BookImage image) {
        this.image = image;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public CartBookDTO getBook() {
        return book;
    }

    public void setBook(CartBookDTO book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "rid=" + rid +
                ", userId='" + userId + '\'' +
                ", book=" + book +
                ", product='" + product + '\'' +
                ", count=" + count +
                ", image=" + image +
                '}';
    }
}
