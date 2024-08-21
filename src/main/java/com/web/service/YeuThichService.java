package com.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.dto.YeuthichDTO;
import com.web.entity.Phim;
import com.web.entity.Tapphim;
import com.web.entity.Users;
import com.web.entity.Yeuthich;
import com.web.reponsitory.TapphimRepository;
import com.web.reponsitory.UsersRepository;
import com.web.reponsitory.YeuthichRepository;

import jakarta.transaction.Transactional;

@Service
public class YeuThichService {
	@Autowired
	YeuthichRepository yeuthichRepository;
	@Autowired
	TapphimRepository tapphimRepository;
	@Autowired
	UsersRepository usersRepository;

	public long countYeuThichByIdPhim(Integer idTapPhim) {
		return yeuthichRepository.countByTapphim_IdTapphim(idTapPhim);
	}

	public Boolean existByGmail(String gmail, Integer idTapphim) {
		return yeuthichRepository.existsByTapphim_IdTapphimAndUsers_Gmail(idTapphim, gmail);
	}

	public List<Integer> findAllByGmail(String gmail) {
		if (!usersRepository.existsById(gmail)) {
			throw new RuntimeException("Gmail này không tồn tại");
		}
		return yeuthichRepository.findAllByGmail(gmail);
	}

	public Yeuthich insert(YeuthichDTO yeuthichDTO) {
		if (!tapphimRepository.existsById(yeuthichDTO.getIdTapphim())) {
			throw new RuntimeException("Mã tập phim này không tồn tại");
		}
		if (!usersRepository.existsById(yeuthichDTO.getGmail())) {
			throw new RuntimeException("Gmail này không tồn tại");
		}
		if (yeuthichRepository.existsByTapphim_IdTapphimAndUsers_Gmail(yeuthichDTO.getIdTapphim(),
				yeuthichDTO.getGmail())) {
			throw new RuntimeException("Gmail này đã thích video này");
		}
		Yeuthich yeuthich = new Yeuthich();
		yeuthich.setTapphim(tapphimRepository.findByIdTapphim(yeuthichDTO.getIdTapphim()));
		yeuthich.setUsers(usersRepository.findByGmail(yeuthichDTO.getGmail()));
		yeuthich.setNgayThich(new Date()); // Set the current date
		return yeuthichRepository.save(yeuthich);
	}

	@Transactional
	public void deleteYeuThich(YeuthichDTO yeuthichDTO) {
		if (!tapphimRepository.existsById(yeuthichDTO.getIdTapphim())) {
			throw new RuntimeException("Mã tập phim này không tồn tại");
		}
		if (!usersRepository.existsById(yeuthichDTO.getGmail())) {
			throw new RuntimeException("Gmail này không tồn tại");
		}
		if (!yeuthichRepository.existsByTapphim_IdTapphimAndUsers_Gmail(yeuthichDTO.getIdTapphim(),
				yeuthichDTO.getGmail())) {
			throw new RuntimeException("Không tìm thấy lượt thích của Gmail này");
		}
		yeuthichRepository.deleteByTapphim_IdTapphimAndUsers_Gmail(yeuthichDTO.getIdTapphim(), yeuthichDTO.getGmail());
		
	}
}
