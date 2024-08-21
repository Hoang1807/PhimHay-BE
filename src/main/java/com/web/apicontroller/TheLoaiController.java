package com.web.apicontroller;

import java.util.List;

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
import com.web.dto.TheloaiDTO;
import com.web.entity.Theloai;
import com.web.entity.Users;
import com.web.service.TheLoaiService;

@RestController
@RequestMapping("/api/v1/theloai")
public class TheLoaiController {
	@Autowired
	TheLoaiService theLoaiService;

	@GetMapping("/all")
	public ApiRespone<List> getListTheLoai() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiService.getAll());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/random")
	public ApiRespone<List> getListTheLoaiRandom() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiService.getRandom());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}


	@PostMapping("/add")
	public ApiRespone<Theloai> addTheLoai(@RequestBody TheloaiDTO tenTheLoai) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiService.insert(tenTheLoai));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("/{id}")
	public ApiRespone<Theloai> getDetailTheLoai(@PathVariable("id") Integer id) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiService.findById(id));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PutMapping("/{id}")
	public ApiRespone<Theloai> updateTheLoai(@PathVariable("id") Integer id, @RequestBody TheloaiDTO theloaiDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(theLoaiService.updateTheLoai(id, theloaiDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@DeleteMapping("/{id}")
	public ApiRespone<Theloai> deleteTheLoai(@PathVariable("id") Integer id) {
		ApiRespone apiRespone = new ApiRespone();
		theLoaiService.deleteTheLoai(id);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
