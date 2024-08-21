package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.TheloaiDTO;
import com.web.entity.Theloai;
import com.web.entity.Users;
import com.web.reponsitory.TheloaiRepository;

@Service
public class TheLoaiService {
	@Autowired
	TheloaiRepository theloaiRepository;

	public List<Theloai> getAll() {
		return theloaiRepository.findAll();
	}
	
	public List<Theloai> getRandom() {
		return theloaiRepository.findRandom3();
	}

	public Theloai findById(Integer id) {
		Theloai theloai = theloaiRepository.findByIdLoai(id);
		if (theloai == null) {
			throw new RuntimeException("Không tìm thấy mã loại");
		}
		return theloai;
	}

	public Theloai insert(TheloaiDTO theloaiDTO) {
		if (theloaiRepository.existsByTenLoai(theloaiDTO.getTenLoai())) {
			throw new RuntimeException("Tên thể loại này đã tồn tại");
		}
		Theloai theloai = new Theloai();
		theloai.setTenLoai(theloaiDTO.getTenLoai());
		return theloaiRepository.save(theloai);
	}

	public Theloai updateTheLoai(Integer id, TheloaiDTO theloaiDTO) {
		Theloai exitsTheloai = theloaiRepository.findByIdLoai(id);
		if (exitsTheloai == null) {
			throw new RuntimeException("không tìm thấy mã thể loại");
		}
		if (theloaiRepository.existsByTenLoai(theloaiDTO.getTenLoai())) {
			throw new RuntimeException("Tên thể loại này đã tồn tại");
		}
		try {
			exitsTheloai.setTenLoai(theloaiDTO.getTenLoai());
			theloaiRepository.save(exitsTheloai);
			return exitsTheloai;
		} catch (Exception e) {
			throw new RuntimeException("Loi");
		}
	}

	public void deleteTheLoai(Integer id) {
		Theloai exitsTheloai = theloaiRepository.findByIdLoai(id);
		if (exitsTheloai == null) {
			throw new RuntimeException("không tìm thấy mã thể loại");
		}
		theloaiRepository.deleteById(id);
	}
}
