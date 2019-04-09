package com.pq.information.api;


import com.pq.common.exception.CommonErrors;
import com.pq.information.dto.ContentDto;
import com.pq.information.service.InformationService;
import com.pq.information.service.SensitiveWordService;
import com.pq.information.utils.InformationResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liutao
 */
@RestController
public class InformationController {
	@Autowired
	private InformationService informationService;
	@Autowired
	private SensitiveWordService sensitiveWordService;

	@GetMapping(value = "/information")
	public InformationResult getInformation(@RequestParam(value = "page",required = false) Integer page,
											@RequestParam(value = "size",required = false) Integer size) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (size == null || size < 1) {
			size = 20;
		}
		int offset = (page - 1) * size;

		InformationResult informationResult = new InformationResult();
		informationResult.setData(informationService.getInformationList(offset,size));
		return informationResult;
	}
	@GetMapping(value = "/index/banner/detail")
	public InformationResult getIndexBannerDetail(@RequestParam(value = "id")Long id) {
		InformationResult informationResult = new InformationResult();
		informationResult.setData(informationService.getIndexBannerById(id));
		return informationResult;
	}
	@GetMapping(value = "/index/banner")
	public InformationResult getIndexBanner() {
		InformationResult informationResult = new InformationResult();
		informationResult.setData(informationService.getIndexBannerList());
		return informationResult;
	}

	@GetMapping(value = "/information/subject/banner")
	public InformationResult getSubjectBanner() {
		InformationResult informationResult = new InformationResult();
		try{
			informationResult.setData(informationService.getSubjectBanner());
		}catch (Exception e){
			e.printStackTrace();
			informationResult.setStatus(CommonErrors.DB_EXCEPTION.getErrorCode());
			informationResult.setMessage(CommonErrors.DB_EXCEPTION.getErrorMsg());
		}
		return informationResult;
	}

	@GetMapping(value = "/information/subject")
	public InformationResult getSubjectList(@RequestParam(value = "page",required = false) Integer page,
											@RequestParam(value = "size",required = false) Integer size) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (size == null || size < 1) {
			size = 20;
		}
		int offset = (page - 1) * size;

		InformationResult informationResult = new InformationResult();
		try{
			informationResult.setData(informationService.getSubjectList(offset,size));
		}catch (Exception e){
			e.printStackTrace();
			informationResult.setStatus(CommonErrors.DB_EXCEPTION.getErrorCode());
			informationResult.setMessage(CommonErrors.DB_EXCEPTION.getErrorMsg());
		}
		return informationResult;
	}

	@RequestMapping(value = "/information/versionControl", method = RequestMethod.GET)
	@ResponseBody
	public InformationResult latest(@RequestParam(value = "client") int client,
									@RequestParam(value = "versionNo") String versionNo,
									@RequestParam(value = "platform") int platform) {
		InformationResult result = new InformationResult();
		result.setData(informationService.getLastVersion(client,versionNo,platform));
		return result;
	}

	@RequestMapping(value = "/information/isHaveSensitiveWord", method = RequestMethod.POST)
	@ResponseBody
	public InformationResult latest(@RequestBody ContentDto contentDto) {
		InformationResult result = new InformationResult();
		result.setData(sensitiveWordService.isHaveSensitiveWord(contentDto.getContent()));
		return result;
	}

}