package cn.gdpi.bookmall.dto;

import cn.gdpi.bookmall.pojo.BookImage;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-20 21:14
 ***/
public class RecommendedBookDTO implements Serializable {
    private static final long serialVersionUID = 7198646634792787806L;
    private String title;
    private BookImage image;
    private String isbn;

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

    public BookImage getImage() {
        return image;
    }

    public void setImage(BookImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RecommendedBookDTO{" +
                "title='" + title + '\'' +
                ", image=" + image +
                '}';
    }
}
