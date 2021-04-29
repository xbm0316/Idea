package cn.gdpi.bookmall.pojo;



import java.io.Serializable;

/**
 * 用户信息表
 *@author lihaotao
 *@description 说明
 *@date 2020-12-17 19:16
 *
 ***/
public class User implements Serializable {
    private static final long serialVersionUID = 1200934798281025261L;
    /**
    * 电话（手机号）
    */
    private String phone;

    /**
    * 用户名
    */
    private String uname;

    /**
    * 密码
    */
    private String upwd;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 角色（1表示管理员）
    */
    private Integer role;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", phone=").append(phone);
        sb.append(", uname=").append(uname);
        sb.append(", upwd=").append(upwd);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append("]");
        return sb.toString();
    }
}