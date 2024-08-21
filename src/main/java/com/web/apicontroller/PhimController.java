package com.web.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.apirespone.ApiRespone;
import com.web.dto.PhimDTO;
import com.web.entity.Phim;
import com.web.entity.Tapphim;
import com.web.service.PhimService;

@RestController
@RequestMapping("/api/v1/phim")
public class PhimController {
	@Autowired
	PhimService phimService;

	@GetMapping("/all")
	public ApiRespone<List> getListPhim() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.getAll());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	@GetMapping("/phimmoi")
	public ApiRespone<Phim> getAllPhimMoi() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.findByAllPhimMoi());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/random")
	public ApiRespone<Phim> getRandom() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.findRandomFourMovies());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("byTheLoai/{id}")
	public ApiRespone<Phim> getPhimByTheLoai(@PathVariable("id") Integer idTheLoai) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.findByIdTheLoai(idTheLoai));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@PostMapping("/add")
	public ApiRespone<Phim> addPhim(@RequestBody PhimDTO phimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.insert(phimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("/{id}")
	public ApiRespone<Phim> getDetailPhim(@PathVariable("id") String id) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.findById(id));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/search")
	public ApiRespone<Phim> searchByName(@RequestParam(value = "keyword", required = false) String name) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.findByName(name));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PutMapping("/{id}")
	public ApiRespone<Phim> updatePhim(@PathVariable("id") String id, @RequestBody PhimDTO phimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(phimService.updatePhim(id, phimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@DeleteMapping("/{id}")
	public ApiRespone<Phim> deleteTheLoai(@PathVariable("id") String id) {
		ApiRespone apiRespone = new ApiRespone();
		phimService.deletePhim(id);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
