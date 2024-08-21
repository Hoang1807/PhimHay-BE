package com.web.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.Theloai;
import java.util.List;


@Repository
public interface TheloaiRepository extends JpaRepository<Theloai, Integer> {
	boolean existsByTenLoai(String tenLoai);
	Theloai findByIdLoai(Integer idLoai);
	@Query(value = "SELECT * FROM Theloai ORDER BY NEWID() OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY", nativeQuery = true)
    List<Theloai> findRandom3();
}

