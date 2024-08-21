package com.web.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.apirespone.ApiRespone;
import com.web.dto.YeuthichDTO;
import com.web.entity.Tapphim;
import com.web.entity.Yeuthich;
import com.web.service.YeuThichService;

@RestController
@RequestMapping("/api/v1/yeuthich")
public class YeuThichController {
	@Autowired
	YeuThichService yeuThichService;

	@PostMapping("/add")
	public ApiRespone<Yeuthich> addYeuThich(@RequestBody YeuthichDTO yeuthichDTO) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(yeuThichService.insert(yeuthichDTO));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/count/{id}")
	public ApiRespone<Long> getCountByIdTapPhim(@PathVariable("id") Integer idTapPhim) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(yeuThichService.countYeuThichByIdPhim(idTapPhim));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/checkLike")
	public ApiRespone<Boolean> checkLike(@RequestParam(value = "idTapphim") Integer idTapphim, @RequestParam String gmail) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(yeuThichService.existByGmail(gmail,idTapphim));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@GetMapping("/getAllVideoLike/{id}")
	public ApiRespone<Integer> getAllVideoLike(@PathVariable("id") String gmail) {
		ApiRespone apiRespone = new ApiRespone();
		apiRespone.setResult(yeuThichService.findAllByGmail(gmail));
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
	
	@DeleteMapping("/unLike")
	public ApiRespone<Yeuthich> deleteYeuThich(@RequestBody YeuthichDTO yeuthichDTO) {
		ApiRespone apiRespone = new ApiRespone();
		yeuThichService.deleteYeuThich(yeuthichDTO);
		apiRespone.setResult("Xóa Thành công");
		apiRespone.setCode(200);
		apiRespone.setMessage("Success");
		return apiRespone;
	}
}
