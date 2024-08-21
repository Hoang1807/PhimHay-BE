package com.web.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "YEUTHICH")
public class Yeuthich {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_yeuthich", unique = true, nullable = false)
	private Integer idYeuthich;
	@ManyToOne
	@JoinColumn(name = "id_tapphim")
	private Tapphim tapphim;
	@ManyToOne
	@JoinColumn(name = "gmail")
	private Users users;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngay_thich", length = 23)
	private Date ngayThich;
}
