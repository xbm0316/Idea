package cn.gdpi.bookmall.util;

import java.util.Random;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 21:17
 ***/
public class CommonUtil {

    public static String getRandomNumber(int len) {
        String source = "0123456789";
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int j = 0; j < len; j++) {
            rs.append(source.charAt(r.nextInt(10)));
        }
        return rs.toString();
    }
}
