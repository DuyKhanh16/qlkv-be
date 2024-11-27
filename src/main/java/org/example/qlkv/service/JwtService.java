package org.example.qlkv.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.qlkv.DTO.UserLoginResponsi;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "QLKVKEYPRIVATEKHANHTNTECHBNVROXLVING2024JAVA"; // Khóa bí mật để ký và xác thực token

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // Lấy loginName từ token
    }
    //    Mục đích: Lấy một trường cụ thể trong phần Claims của JWT.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    // Lấy toàn bộ nội dung Claims từ JWT.
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //    Tạo JWT cho người dùng.
    public String generateToken(UserLoginResponsi userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.toString());
    }
    // Tạo JWT dựa trên các thông tin được cung cấp
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 giờ
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    //Kiểm tra xem JWT có hợp lệ hay không
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    // kiểm tra xem token có hết hạn không
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}