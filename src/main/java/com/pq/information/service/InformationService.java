package com.pq.information.service;


import com.pq.information.dto.*;
import com.pq.information.entity.Subject;

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
     * 获取详情
     * @param id
     * @return
     */
    IndexBannerDetailDto getIndexBannerById(Long id);

    /**
     * 获取资讯列表
     * @param offset
     * @param size
     * @return
     */
    List<InformationDto> getInformationList(Integer offset,Integer size);

    /**
     * 获取首页banner信息
     * @return
     */
    SubjectBannerDto getSubjectBanner();

    /**
     * 获取精选课题
     * @param offset
     * @param size
     * @return
     */
    List<SubjectDto> getSubjectList(int offset,int size);

    /**
     * 获取最新版本
     * @param client
     * @param versionNo
     * @return
     */
    ReleaseVersionDto getLastVersion(int client,String versionNo);

}
