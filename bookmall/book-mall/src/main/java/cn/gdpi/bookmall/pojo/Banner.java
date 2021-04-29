package cn.gdpi.bookmall.pojo;

import java.io.Serializable;

/**
 *
 * banner记录表
 *@author lihaotao
 *@description 说明
 *@date 2020-12-23 14:42
 *
***/
public class Banner implements Serializable {
    /**
    * 记录编号
    */
    private Integer rid;

    /**
    * 商品（商品编号）
    */
    private String product;

    private String url;

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", product=").append(product);
        sb.append("]");
        return sb.toString();
    }
}