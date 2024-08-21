package com.web.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.Tapphim;

@Repository
public interface TapphimRepository extends JpaRepository<Tapphim, Integer> {
	Tapphim findByIdTapphim(Integer idTapphim);

	List<Tapphim> findAllByPhim_IdPhim(String phimId);

	List<Tapphim> findTop8ByOrderByNgayTaoDesc();
	
	@Query("SELECT t FROM Tapphim t JOIN Theloaiphim tlp ON t.phim.idPhim = tlp.phim.idPhim WHERE tlp.theloai.idLoai = :idLoai")
    List<Tapphim> findByTheloaiId(@Param("idLoai") Integer idLoai);
	List<Tapphim> findTop5ByOrderByLuotXemDesc();
}
