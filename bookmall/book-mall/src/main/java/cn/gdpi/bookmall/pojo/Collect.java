package cn.gdpi.bookmall.pojo;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:39
 ***/
public class Collect {

    private Integer rid;
    private String userId;
    private String product;

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

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "rid=" + rid +
                ", userId='" + userId + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
