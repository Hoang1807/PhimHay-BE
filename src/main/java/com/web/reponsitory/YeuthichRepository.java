package com.web.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.Yeuthich;

@Repository
public interface YeuthichRepository extends JpaRepository<Yeuthich, Integer> {
	Yeuthich findByIdYeuthich(Integer idYeuthich);
	boolean existsByTapphim_IdTapphimAndUsers_Gmail(Integer idTapphim, String gmail);
	long countByTapphim_IdTapphim(Integer idTapphim);
	void deleteByTapphim_IdTapphimAndUsers_Gmail(Integer idTapphim, String gmail);
	@Query("SELECT t.tapphim.idTapphim FROM Yeuthich t WHERE t.users.gmail = :gmail")
	List<Integer> findAllByGmail(@Param("gmail") String gmail);
	
	
}
