package com.web.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.web.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {
	public static final String SERECT = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	// Tao jwt du tren username NV
	public String generateToken(Users users) {
		Map<String, Objects> claims = new HashMap<>();
		// claims.put("isAdmin", true);
		return createToken(claims, users);
	}

	// Taok JWT voi cac claims
	private String createToken(Map<String, Objects> claims, Users users) {
		return Jwts.builder().setClaims(claims).setSubject(users.getGmail()).claim("role", users.getVaiTro())
				.claim("username", users.getGmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600 * 60 * 1000)) // Jwt hwt han sau 1 tieng
				.signWith(SignatureAlgorithm.HS256, getSignKey()).compact();
	}

	// Lay SERECT_KEY
	private Key getSignKey() {
		byte[] keyByte = Decoders.BASE64.decode(SERECT);
		return Keys.hmacShaKeyFor(keyByte);
	}

	// Trích xuất thông tin
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
	}

	// Trích xuất TT cho 1 claims
	public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
		final Claims claims = extractAllClaims(token);
		return claimsTFunction.apply(claims);
	}

	// Kiem tra Token het han
	public Date exTractExpiriration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	// Lay ra username
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);

	}

	// Kiểm tra cái JWT đã hết hạn
	private Boolean isTokenExpired(String token) {
		return exTractExpiriration(token).before(new Date());
	}

	// Kiểm tra tính hợp lệ
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String tenDangNhap = extractUsername(token);
		return (tenDangNhap.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
