package cn.gdpi.bookmall.pojo;

import java.io.Serializable;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-18 10:40
 *
***/
public class BookImage implements Serializable {
    private static final long serialVersionUID = -6503803888769470351L;
    private Long imgId;

    private Integer type;

    private String url;

    private String bookIsbn;

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", bookIsbn=").append(bookIsbn);
        sb.append("]");
        return sb.toString();
    }
}