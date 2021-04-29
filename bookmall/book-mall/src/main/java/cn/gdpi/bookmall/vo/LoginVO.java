package cn.gdpi.bookmall.vo;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-20 19:21
 ***/
public class LoginVO {

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String upwd;


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

    @Override
    public String toString() {
        return "LoginVO{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
