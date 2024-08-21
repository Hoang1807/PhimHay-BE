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
import com.web.dto.TapphimDTO;
import com.web.entity.Tapphim;
import com.web.service.TapPhimService;

@RestController
@RequestMapping("/api/v1/tapphim")
public class TapPhimController {
	@Autowired
	TapPhimService tapPhimService;

	@PostMapping("/add")
	public ApiRespone<Tapphim> addTapPhim(@RequestBody TapphimDTO tapphimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.insert(tapphimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@PutMapping("/{id}")
	public ApiRespone<Tapphim> updateTapPhim(@PathVariable("id") Integer id, @RequestBody TapphimDTO tapphimDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.updateTapPhim(id, tapphimDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@PutMapping("/updateView/{id}")
	public ApiRespone<Tapphim> updateView(@PathVariable("id") Integer id) {
		System.out.println(id);
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.updateView(id));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}

	@GetMapping("byPhim/{id}")
	public ApiRespone<Tapphim> getTapPhim(@PathVariable("id") String idMaPhim) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.findByIdPhim(idMaPhim));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("byTheLoai/{id}")
	public ApiRespone<Tapphim> getTapPhimByTheLoai(@PathVariable("id") Integer idTheLoai) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.findByIdTheLoai(idTheLoai));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/{id}")
	public ApiRespone<Tapphim> getDetailTapPhim(@PathVariable("id") Integer idMaTapPhim) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.findByIdTapphim(idMaTapPhim));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/tapphimmoi")
	public ApiRespone<Tapphim> getAllTapPhimMoi() {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(tapPhimService.findByAllTapPhimMoi());
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/top-5-views")
    public ApiRespone<Tapphim> getTop5EpisodesByViews() {
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(tapPhimService.getTop5EpisodesByViews());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
	
	@DeleteMapping("/{id}")
	public ApiRespone<Tapphim> deleteTapPhim(@PathVariable("id") Integer id) {
		ApiRespone apiRespone = new ApiRespone();
		tapPhimService.deleteTapPhim(id);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
