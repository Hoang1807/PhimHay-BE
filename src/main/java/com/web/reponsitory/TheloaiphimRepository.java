package com.web.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.Theloaiphim;
import java.util.List;

@Repository
public interface TheloaiphimRepository extends JpaRepository<Theloaiphim, Integer> {
	@Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Theloaiphim t WHERE t.phim.idPhim = :phimId AND t.theloai.idLoai = :theloaiId")
	boolean existsByPhimIdAndTheloaiId(@Param("phimId") String phimId, @Param("theloaiId") Integer theloaiId);

	boolean existsByIdTheloaiphim(Integer idTheloaiphim);

	Theloaiphim findByIdTheloaiphim(Integer idTheloaiphim);

	@Query("SELECT t.theloai.idLoai FROM Theloaiphim t WHERE t.phim.idPhim = :phimId")
	List<Integer> findAllByPhimId(@Param("phimId") String phimId);
	
	void deleteByPhim_IdPhim(String phimId);
}
