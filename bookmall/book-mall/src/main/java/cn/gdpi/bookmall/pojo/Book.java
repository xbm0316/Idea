package cn.gdpi.bookmall.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 图书信息表
 *@author lihaotao
 *@description 说明
 *@date 2020-12-17 19:18
 *
***/
public class Book implements Serializable {
    private static final long serialVersionUID = 1934202362187572685L;
    /**
    * 图书编号
    */
    private String isbn;

    /**
    * 标题（书名）
    */
    private String title;

    /**
    * 作者
    */
    private String author;

    /**
    * 价格
    */
    private Double price;

    /**
    * 出版社
    */
    private String press;

    /**
    * 版次
    */
    private Integer edition;

    /**
    * 出版日期/时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date published;

    /**
    * 页数
    */
    private Integer pages;

    /**
    * 字数
    */
    private Integer words;

    /**
    * 包装
    */
    private String packaging;

    /**
    * 开本
    */
    private String format;

    /**
    * 用纸
    */
    private String form;


    private List<BookImage> images;


    public List<BookImage> getImages() {
        return images;
    }

    public void setImages(List<BookImage> images) {
        this.images = images;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", edition=" + edition +
                ", published=" + published +
                ", pages=" + pages +
                ", words=" + words +
                ", packaging='" + packaging + '\'' +
                ", format='" + format + '\'' +
                ", form='" + form + '\'' +
                ", images=" + images +
                '}';
    }
}