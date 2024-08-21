package com.web.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Users;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	public Users findByGmail(String gmail);
}