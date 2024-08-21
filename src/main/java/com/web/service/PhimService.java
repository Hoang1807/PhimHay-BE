package com.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.PhimDTO;
import com.web.entity.Phim;
import com.web.entity.Tapphim;
import com.web.entity.Theloai;
import com.web.reponsitory.PhimRepository;
import com.web.reponsitory.TheloaiRepository;

@Service
public class PhimService {
	@Autowired
	PhimRepository phimRepository;
	@Autowired
	TheloaiRepository theloaiRepository;

	public List<Phim> getAll() {
		return phimRepository.findAll();
	}

	public Phim findById(String id) {
		Phim phim = phimRepository.findByIdPhim(id);
		if (phim == null) {
			throw new RuntimeException("không tìm thấy phim");
		}
		return phim;
	}

	public List<Phim> findByAllPhimMoi() {
		return phimRepository.findTop8ByOrderByNgayTaoDesc();
	}

	public List<Phim> findByName(String name) {
		if (name == null || name.trim().isEmpty()) {
			return phimRepository.findAll();
		} else {
			return phimRepository.findByTenPhimContainingIgnoreCase(name);
		}
	}

	public List<Phim> findRandomFourMovies() {
		return phimRepository.findRandomFourMovies();
	}

	public List<Phim> findByIdTheLoai(Integer idTheLoai) {
		Theloai existTheloai = theloaiRepository.findByIdLoai(idTheLoai);
		if (existTheloai == null) {
			throw new RuntimeException("Mã thể loại này không tồn tại");
		}
		return phimRepository.findByTheloaiId(idTheLoai);
	}

	public Phim insert(PhimDTO phimDTO) {
		Phim exitsPhim = phimRepository.findByIdPhim(phimDTO.getIdPhim());
		if (exitsPhim != null) {
			throw new RuntimeException("Mã phim đã tồn tại");
		}
		Phim newPhim = new Phim();
		BeanUtils.copyProperties(phimDTO, newPhim);
		newPhim.setNgayTao(new Date());
		return phimRepository.save(newPhim);
	}

	public Phim updatePhim(String id, PhimDTO phimDTO) {
		Phim exitsPhim = phimRepository.findByIdPhim(phimDTO.getIdPhim());
		if (exitsPhim == null) {
			throw new RuntimeException("không tìm thấy mã phim");
		}
		try {
			exitsPhim.setTacGia(phimDTO.getTacGia());
			exitsPhim.setTenPhim(phimDTO.getTenPhim());
			exitsPhim.setTrangThai(phimDTO.getTrangThai());
			exitsPhim.setMoTa(phimDTO.getMoTa());
			exitsPhim.setHinhPhim(phimDTO.getHinhPhim());
			phimRepository.save(exitsPhim);
			return exitsPhim;
		} catch (Exception e) {
			throw new RuntimeException("Loi");
		}
	}

	public void deletePhim(String id) {
		Phim exitsPhim = phimRepository.findByIdPhim(id);
		if (exitsPhim == null) {
			throw new RuntimeException("không tìm thấy mã phim");
		}
		phimRepository.deleteById(id);
	}
}
