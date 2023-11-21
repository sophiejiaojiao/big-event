package com.study;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试生成jwt令牌
 */
public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))//添加过期时间
                .sign(Algorithm.HMAC256("itheima"));//调用算法，配置密钥，如黑马
        System.out.printf(token);
    }

    @Test
    public void testParse(){
        // 定义字符串，模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MDA0MzQ0NDJ9.EQkG28Aj-N2FBaPDYJpp6L3vxMw7tzMGGmXA2HRf5-A";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build(); // 生成一个验证器，这里解密算法和密钥需要和上方生成时一致
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//解析token，生成解析后的jwt对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
