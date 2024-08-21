package com.web.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.TheloaiphimDTO;
import com.web.entity.Phim;
import com.web.entity.Theloai;
import com.web.entity.Theloaiphim;
import com.web.entity.Users;
import com.web.reponsitory.PhimRepository;
import com.web.reponsitory.TheloaiRepository;
import com.web.reponsitory.TheloaiphimRepository;

import jakarta.transaction.Transactional;

@Service
public class TheLoaiPhimService {
	@Autowired
	TheloaiphimRepository theloaiphimRepository;
	@Autowired
	PhimRepository phimRepository;
	@Autowired
	TheloaiRepository theloaiRepository;

	public List<Integer> findByIdMaPhim(String idMaPhim) {
		Phim existPhim = phimRepository.findByIdPhim(idMaPhim);
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		return theloaiphimRepository.findAllByPhimId(idMaPhim);
	}

	public Theloaiphim insert(TheloaiphimDTO theloaiphimDTO) {
		if (theloaiphimRepository.existsByPhimIdAndTheloaiId(theloaiphimDTO.getIdPhim(), theloaiphimDTO.getIdLoai())) {
			throw new RuntimeException("Thế loại của phim này đã tồn tại");
		}
		Phim existPhim = phimRepository.findByIdPhim(theloaiphimDTO.getIdPhim());
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		Theloai exisTheloai = theloaiRepository.findByIdLoai(theloaiphimDTO.getIdLoai());
		if (exisTheloai == null) {
			throw new RuntimeException("Mã thể loại này không tồn tại");
		}
		Theloaiphim newTheloaiphim = new Theloaiphim();
		newTheloaiphim.setPhim(existPhim);
		newTheloaiphim.setTheloai(exisTheloai);
		return theloaiphimRepository.save(newTheloaiphim);
	}

	public Theloaiphim updateTheLoaiPhim(Integer id, TheloaiphimDTO theloaiphimDTO) {
		Theloaiphim existTheloaiphim = theloaiphimRepository.findByIdTheloaiphim(id);
		if (existTheloaiphim == null) {
			throw new RuntimeException("không tìm thấy mã thể loại phim");
		}
		Phim existPhim = phimRepository.findByIdPhim(theloaiphimDTO.getIdPhim());
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		Theloai exisTheloai = theloaiRepository.findByIdLoai(theloaiphimDTO.getIdLoai());
		if (exisTheloai == null) {
			throw new RuntimeException("Mã thể loại này không tồn tại");
		}
		try {
			existTheloaiphim.setPhim(existPhim);
			existTheloaiphim.setTheloai(exisTheloai);
			theloaiphimRepository.save(existTheloaiphim);
			return existTheloaiphim;
		} catch (Exception e) {
			throw new RuntimeException("Loi");
		}
	}
	@Transactional
	public void deleteTheLoaiPhim(String id) {
		Phim existPhim = phimRepository.findByIdPhim(id);
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		theloaiphimRepository.deleteByPhim_IdPhim(id);
	}
}
