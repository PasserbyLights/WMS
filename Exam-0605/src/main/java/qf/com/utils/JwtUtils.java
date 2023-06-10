package qf.com.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 生成token令牌以及token令牌的验证
 */
public class JwtUtils {

    /**
     * 生成token(数据加密又叫做签名sign)
     */
    public static String sign(String userEmail, String password) {
        //创建算法实例
        Algorithm algorithm = Algorithm.HMAC256(password);
        //System.out.println("token生成前……");
        try {
            String token = JWT.create()
                    .withIssuer(userEmail)  //设置自定义参数（负载）
                    .sign(algorithm);//头
            //System.out.println("token生成后……");
            System.out.println("token:" + token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取token中负载部分的值
     */
    public static String getClaim(String token, String key) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(key).asString();
    }


    /**
     * token校验
     */
    public static Boolean verify(String token, String userEmail, String password) {
        Algorithm algorithm = Algorithm.HMAC256(password);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(userEmail).build();
        verifier.verify(token);
        return true;
    }

    public static void main(String[] args) {

        //String token = sign("admin", "123456");
        //System.out.println(token);
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZG1pbiJ9.6_s_oo-i0znjDaS85KSafB57yzdAy9dWe0zuAvjQRpU";

        verify(token, "admin", "123456");

    }
}
