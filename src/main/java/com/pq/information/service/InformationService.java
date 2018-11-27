package com.pq.information.service;


import com.pq.information.dto.IndexBannerDto;
import com.pq.information.dto.InformationDto;

import java.util.List;

/**
 * 资讯服务
 * @author liutao
 */
public interface InformationService {

    /**
     * 获取首页banner
     * @return
     */
    List<IndexBannerDto> getIndexBannerList();

    /**
     * 获取资讯列表
     * @return
     */
    List<InformationDto> getInformationList(Integer offset,Integer size);
}
