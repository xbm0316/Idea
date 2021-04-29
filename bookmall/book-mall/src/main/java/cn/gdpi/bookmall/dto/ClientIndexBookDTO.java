package cn.gdpi.bookmall.dto;

import cn.gdpi.bookmall.pojo.BookImage;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-19 15:24
 ***/
public class ClientIndexBookDTO implements Serializable {
    private static final long serialVersionUID = -3130589867020412343L;
    /**
     * 图书编号
     */
    private String isbn;

    /**
     * 标题（书名）
     */
    private String title;

    /**
     * 价格
     */
    private Double price;

    /**
     * 出版社
     */
    private String press;


    private BookImage image;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public BookImage getImage() {
        return image;
    }

    public void setImage(BookImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ClientIndexBookDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", image=" + image +
                '}';
    }
}
