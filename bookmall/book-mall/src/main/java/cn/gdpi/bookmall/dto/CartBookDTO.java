package cn.gdpi.bookmall.dto;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-21 11:15
 ***/
public class CartBookDTO implements Serializable {
    private static final long serialVersionUID = -4267040684901965700L;
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
     * 作者
     */
    private String author;


    /**
     * 出版社
     */
    private String press;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "CartBookDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
