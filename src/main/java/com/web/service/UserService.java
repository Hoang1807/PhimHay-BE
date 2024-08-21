package com.web.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.entity.Users;
import com.web.reponsitory.UsersRepository;
import com.web.security.LoginRequest;

@Service
public class UserService {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<Users> getAll() {
		return usersRepository.findAll();
	}

	public Users findByGmail(String gmail) {
		Users user = usersRepository.findByGmail(gmail);
		if (user == null) {
			throw new RuntimeException("không tìm thấy tài khoản");
		}
		return user;
	}

	public Users register(LoginRequest request) {
		Users foundedEmail = usersRepository.findByGmail(request.getGmail());
		if (foundedEmail != null) {
			throw new RuntimeException("Email đã được sử dụng");
		}
		Users users = new Users();
		BeanUtils.copyProperties(request, users);
		users.setVaiTro(false);
		String encryptPassword = passwordEncoder.encode(request.getMatKhau());
		users.setMatKhau(encryptPassword);
		return usersRepository.save(users);
	}

	public Users insert(Users user) {
		Users foundedEmail = usersRepository.findByGmail(user.getGmail());
		if (foundedEmail != null) {
			throw new RuntimeException("Email đã được sử dụng");
		}
		Users newUser = new Users();
		BeanUtils.copyProperties(user, newUser);
		String encryptPassword = passwordEncoder.encode(newUser.getMatKhau());
		newUser.setMatKhau(encryptPassword);
		return usersRepository.save(newUser);
	}

	public Users updateUser(String gmail, Users user) {
		Users existUsers = usersRepository.findByGmail(gmail);
		if (existUsers == null) {
			throw new RuntimeException("không tìm thấy tài khoản");
		}
		try {
			existUsers.setVaiTro(user.getVaiTro());
			String encryptPassword = passwordEncoder.encode(user.getMatKhau());
			existUsers.setMatKhau(encryptPassword);
			usersRepository.save(existUsers);
			return existUsers;
		} catch (Exception e) {
			throw new RuntimeException("Loi");
		}
	}

	public void deleteUser(String gmail) {
		Users existUsers = usersRepository.findByGmail(gmail);
		if (existUsers == null) {
			throw new RuntimeException("không tìm thấy tài khoản");
		}
		usersRepository.deleteById(gmail);
	}
}
