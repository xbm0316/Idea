package cn.gdpi.bookmall.dto;

import cn.gdpi.bookmall.pojo.BookImage;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-19 20:39
 ***/
public class CollectBookDTO implements Serializable {
    private static final long serialVersionUID = -7504158277392923594L;

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
                ", image=" + image +
                '}';
    }
}
