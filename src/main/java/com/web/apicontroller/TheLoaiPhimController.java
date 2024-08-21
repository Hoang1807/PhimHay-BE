package com.web.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.apirespone.ApiRespone;
import com.web.dto.TheloaiphimDTO;
import com.web.entity.Theloaiphim;
import com.web.service.TheLoaiPhimService;

@RestController
@RequestMapping("/api/v1/theloaiphim")
public class TheLoaiPhimController {
	@Autowired
	TheLoaiPhimService theLoaiPhimService;

	@PostMapping("/add")
	public ApiRespone<Theloaiphim> addTheLoaiPhim(@RequestBody TheloaiphimDTO theloaiphimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiPhimService.insert(theloaiphimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("/{id}")
	public ApiRespone<Theloaiphim> getDetailTheLoaiPhim(@PathVariable("id") String idMaPhim) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiPhimService.findByIdMaPhim(idMaPhim));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PutMapping("/{id}")
	public ApiRespone<Theloaiphim> updateTheloaiPhim(@PathVariable("id") Integer id,
			@RequestBody TheloaiphimDTO theloaiphimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiPhimService.updateTheLoaiPhim(id, theloaiphimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@DeleteMapping("/{id}")
	public ApiRespone<Theloaiphim> deleteTheLoaiPhim(@PathVariable("id") String id) {
		ApiRespone apiRespone = new ApiRespone();
		theLoaiPhimService.deleteTheLoaiPhim(id);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
