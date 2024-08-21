package com.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.web.entity.Users;

public interface AccountService extends UserDetailsService {
    public Users findUsersByGmail(String gmail);
}

