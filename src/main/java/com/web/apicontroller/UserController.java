package com.web.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.apirespone.ApiRespone;
import com.web.entity.Users;
import com.web.security.JwtResponse;
import com.web.security.LoginRequest;
import com.web.service.JWTService;
import com.web.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	JWTService jwtService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		// Xac thuc nguoi dung bang username va password
		Users users = userService.findByGmail(loginRequest.getGmail());
		try {
			Authentication authentication = manager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getGmail(), loginRequest.getMatKhau()));
			if (authentication.isAuthenticated()) {
				final String jwt = jwtService.generateToken(users);
				return ResponseEntity.ok().body(new JwtResponse(jwt));
			}
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().body("Login Fail, Username or Password Incorrect");
		}
		return ResponseEntity.badRequest().body("Login Fail");
	}

	@PostMapping("/register")
	public ApiRespone<Users> register(@RequestBody LoginRequest registerRequest) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.register(registerRequest));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("/all")
	public ApiRespone<List> getListUser() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.getAll());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PostMapping("/add")
	public ApiRespone<Users> addUser(@RequestBody Users user) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.insert(user));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("/{id}")
	public ApiRespone<Users> getDetailUser(@PathVariable("id") String gmail) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.findByGmail(gmail));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PutMapping("/{id}")
	public ApiRespone<Users> updateUser(@PathVariable("id") String gmail, @RequestBody Users user) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.updateUser(gmail, user));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@DeleteMapping("/{id}")
	public ApiRespone<Users> deleteUser(@PathVariable("id") String gmail) {
		ApiRespone apiRespone = new ApiRespone();
		userService.deleteUser(gmail);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
