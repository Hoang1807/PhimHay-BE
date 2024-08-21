package com.web.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.apirespone.ApiRespone;
import com.web.entity.Users;
import com.web.service.UserService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public ApiRespone<Users> getDetailUser(@PathVariable("id") String gmail) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(userService.findByGmail(gmail));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
