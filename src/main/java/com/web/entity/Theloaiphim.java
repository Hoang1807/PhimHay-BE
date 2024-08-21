package com.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "THELOAIPHIM")
public class Theloaiphim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_theloaiphim", unique = true, nullable = false)
	private Integer idTheloaiphim;
	@ManyToOne
	@JoinColumn(name = "id_phim")
	private Phim phim;
	@ManyToOne
	@JoinColumn(name = "id_loai")
	private Theloai theloai;
}
