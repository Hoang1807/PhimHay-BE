package com.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class Users {

	@Id
	@Column(name = "gmail", unique = true, nullable = false, length = 50)
	private String gmail;
	@Column(name = "mat_khau", nullable = false, length = 60)
	private String matKhau;
	@Column(name = "vai_tro")
	private Boolean vaiTro;
}