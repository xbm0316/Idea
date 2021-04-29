package cn.gdpi.bookmall.util;

import cn.gdpi.bookmall.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtTokenUtil {

    private final String secret="lihaotaofyu";
    private final Long expiration=86400L;


    /**
     * 生成token令牌
     *
     * @param user 用户
     * @return 令token牌
     */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>(5);
        claims.put("sub", user.getPhone());
        claims.put("role",user.getRole());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getPhoneFromToken(String token) {
        String phone;
        try {
            Claims claims = getClaimsFromToken(token);
            phone = claims.getSubject();
        } catch (Exception e) {
            phone = null;
        }
        return phone;
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public Integer getRoleFromToken(String token) {
        Integer role;
        try {
            Claims claims = getClaimsFromToken(token);
            role= (Integer) claims.get("role");
        } catch (Exception e) {
            role = null;
        }
        return role;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param user 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token,User user) {

        String phone = getPhoneFromToken(token);
        return (phone.equals(user.getPhone()) && !isTokenExpired(token));
    }


    /**
     * 从claims生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        //token有效时间是24小时
        Date expirationDate = new Date(System.currentTimeMillis() + expiration*1000);
        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明,如果看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}
