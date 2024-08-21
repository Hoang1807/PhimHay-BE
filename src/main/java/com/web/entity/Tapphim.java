package com.web.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAPPHIM")
public class Tapphim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tapphim", unique = true, nullable = false)
	private Integer idTapphim;
	@ManyToOne
	@JoinColumn(name = "id_phim")
	private Phim phim;
	@Column(name = "ten_tapphim", nullable = false)
	private String tenTapphim;
	@Column(name = "luot_xem")
	private Integer luotXem;
	@Column(name = "hinh_tapphim", nullable = false)
	private String hinhTapphim;
	@Column(name = "link_video", nullable = false)
	private String linkVideo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngay_tao", length = 23)
	private Date ngayTao;
}
