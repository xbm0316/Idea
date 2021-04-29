package cn.gdpi.bookmall.vo;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-19 22:45
 ***/
public class UpdatePwdVO {
    /**
     * 新密码
     */
    private String npwd;
    /**
     * 原密码
     */
    private String upwd;

    public String getNpwd() {
        return npwd;
    }

    public void setNpwd(String npwd) {
        this.npwd = npwd;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "UpdatePwdVO{" +
                "npwd='" + npwd + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
