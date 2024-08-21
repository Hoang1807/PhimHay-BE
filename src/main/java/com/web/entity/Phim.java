package com.web.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHIM")
public class Phim {
	@Id
	@Column(name = "id_phim", unique = true, nullable = false, length = 100)
	private String idPhim;
	@Column(name = "ten_phim", nullable = false)
	private String tenPhim;
	@Column(name = "hinh_phim")
	private String hinhPhim;
	@Column(name = "mo_ta")
	private String moTa;
	@Column(name = "tac_gia", nullable = false)
	private String tacGia;
	@Column(name = "trang_thai")
	private Boolean trangThai;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngay_tao", length = 23)
	private Date ngayTao;
}
