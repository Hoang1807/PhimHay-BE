package com.web.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, String> {
	Phim findByIdPhim(String idPhim);

	List<Phim> findTop8ByOrderByNgayTaoDesc();

	@Query(value = "SELECT * FROM Phim ORDER BY NEWID() OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY", nativeQuery = true)
	List<Phim> findRandomFourMovies();

	@Query("SELECT p FROM Phim p JOIN Theloaiphim tlp ON p.idPhim = tlp.phim.idPhim WHERE tlp.theloai.idLoai = :idLoai")
	List<Phim> findByTheloaiId(Integer idLoai);
	List<Phim> findByTenPhimContainingIgnoreCase(String tenPhim);
}
