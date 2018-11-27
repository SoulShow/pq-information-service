package com.pq.information.api;


import com.pq.information.service.InformationService;
import com.pq.information.utils.InformationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liutao
 */
@RestController
public class InformationController {
	@Autowired
	private InformationService informationService;
	@GetMapping(value = "/information")
	public InformationResult getInformation(@RequestParam(value = "page",required = false) Integer page,
											@RequestParam(value = "size",required = false) Integer size) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (size == null || size < 1) {
			size = 10;
		}
		int offset = (page - 1) * size;

		InformationResult informationResult = new InformationResult();
		informationResult.setData(informationService.getInformationList(offset,size));
		return informationResult;
	}
	@GetMapping(value = "/index/banner")
	public InformationResult getIndexBanner() {
		InformationResult informationResult = new InformationResult();
		informationResult.setData(informationService.getIndexBannerList());
		return informationResult;
	}

}