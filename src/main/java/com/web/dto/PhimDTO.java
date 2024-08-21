package com.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhimDTO {
	private String idPhim;
    private String tenPhim;
    private String hinhPhim;
    private String moTa;
    private String tacGia;
    private Boolean trangThai;
}
