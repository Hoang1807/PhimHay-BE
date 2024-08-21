package com.web.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.entity.Users;
import com.web.reponsitory.UsersRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	public AccountServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public Users findUsersByGmail(String gmail) {
		return usersRepository.findByGmail(gmail);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = findUsersByGmail(username);
		if (users == null) {
			throw new RuntimeException("tài khoản không tồn tại");
		}

		String username1 = users.getGmail();
		String password = users.getMatKhau();
		String chucvu = null;
		if (username1 == null || password == null) {
			throw new RuntimeException("Không hợp lệ");
		}
		boolean role = users.getVaiTro();
		if (role) {
			chucvu = "admin";
		} else {
			chucvu = "user";
		}
		System.out.println(chucvu);
		return new User(username, password, Collections.singletonList(new SimpleGrantedAuthority(chucvu)));
	}
	
}
