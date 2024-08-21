package com.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TapphimDTO {
	private Integer idTapphim;
	private String idPhim;
	private String tenTapphim;
	private Integer luotXem;
	private String hinhTapphim;
	private String linkVideo;
}
