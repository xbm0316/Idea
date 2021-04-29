package cn.gdpi.bookmall.util;

import java.io.Serializable;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:37
 ***/

public class Return implements Serializable {
    private static final long serialVersionUID = 480838447030042980L;

    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Return ok(int code, Object data){
        Return r = new Return();
        r.setCode(code);
        r.setData(data);
        return r;
    }

    public static Return ok(int code, String msg){
        Return r = new Return();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static Return ok(int code, Object data,String msg){
        Return r = new Return();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }
    public static Return error(int code, String msg){
        Return r = new Return();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    @Override
    public String toString() {
        return "Return{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
