package com.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.TapphimDTO;
import com.web.entity.Phim;
import com.web.entity.Tapphim;
import com.web.entity.Theloai;
import com.web.entity.Theloaiphim;
import com.web.reponsitory.PhimRepository;
import com.web.reponsitory.TapphimRepository;
import com.web.reponsitory.TheloaiRepository;

import jakarta.transaction.Transactional;

@Service
public class TapPhimService {
	@Autowired
	TapphimRepository tapphimRepository;
	@Autowired
	PhimRepository phimRepository;
	@Autowired
	TheloaiRepository theloaiRepository;

	public List<Tapphim> findByIdPhim(String idMaPhim) {
		Phim existPhim = phimRepository.findByIdPhim(idMaPhim);
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		return tapphimRepository.findAllByPhim_IdPhim(idMaPhim);
	}

	public List<Tapphim> findByIdTheLoai(Integer idTheLoai) {
		Theloai existTheloai = theloaiRepository.findByIdLoai(idTheLoai);
		if (existTheloai == null) {
			throw new RuntimeException("Mã thể loại này không tồn tại");
		}
		return tapphimRepository.findByTheloaiId(idTheLoai);
	}

	public List<Tapphim> findByAllTapPhimMoi() {
		return tapphimRepository.findTop8ByOrderByNgayTaoDesc();
	}

	public Tapphim findByIdTapphim(Integer idMaTapPhim) {
		Tapphim existTapPhim = tapphimRepository.findByIdTapphim(idMaTapPhim);
		if (existTapPhim == null) {
			throw new RuntimeException("Mã tập phim này không tồn tại");
		}
		return existTapPhim;
	}

	public Tapphim insert(TapphimDTO tapphimDTO) {
		Phim existPhim = phimRepository.findByIdPhim(tapphimDTO.getIdPhim());
		if (existPhim == null) {
			throw new RuntimeException("Mã phim này không tồn tại");
		}
		Tapphim newTapphim = new Tapphim();
		BeanUtils.copyProperties(tapphimDTO, newTapphim);
		newTapphim.setPhim(existPhim);
		newTapphim.setNgayTao(new Date());
		return tapphimRepository.save(newTapphim);
	}

	public Tapphim updateTapPhim(Integer id, TapphimDTO tapphimDTO) {
		Tapphim existTapphim = tapphimRepository.findByIdTapphim(id);
		if (existTapphim == null) {
			throw new RuntimeException("không tìm thấy mã tập phim");
		}
		try {
			existTapphim.setTenTapphim(tapphimDTO.getTenTapphim());
			existTapphim.setLuotXem(tapphimDTO.getLuotXem());
			existTapphim.setHinhTapphim(tapphimDTO.getHinhTapphim());
			existTapphim.setLinkVideo(tapphimDTO.getLinkVideo());
			tapphimRepository.save(existTapphim);
			return existTapphim;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Loi");
		}
	}

	public List<Tapphim> getTop5EpisodesByViews() {
		return tapphimRepository.findTop5ByOrderByLuotXemDesc();
	}

	public Tapphim updateView(Integer id) {
		Tapphim existTapphim = tapphimRepository.findByIdTapphim(id);
		if (existTapphim == null) {
			throw new RuntimeException("không tìm thấy mã tập phim");
		}
		try {
			existTapphim.setLuotXem(existTapphim.getLuotXem() + 1);
			tapphimRepository.save(existTapphim);
			return existTapphim;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Loi");
		}
	}

	@Transactional
	public void deleteTapPhim(Integer id) {
		Tapphim existTapPhim = tapphimRepository.findByIdTapphim(id);
		if (existTapPhim == null) {
			throw new RuntimeException("Mã tập phim này không tồn tại");
		}
		tapphimRepository.deleteById(id);
	}
}
