package cn.gdpi.bookmall.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-19 15:48
 ***/
public class AdminProductListBook implements Serializable {

    private static final long serialVersionUID = 9020640040282263087L;
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

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date published;

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

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "AdminProductListBook{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", published=" + published +
                '}';
    }
}
