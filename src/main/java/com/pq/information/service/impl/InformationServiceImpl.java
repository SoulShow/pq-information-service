package com.pq.information.service.impl;

import com.pq.common.util.DateUtil;
import com.pq.information.dto.IndexBannerDto;
import com.pq.information.dto.InformationDto;
import com.pq.information.entity.IndexBanner;
import com.pq.information.entity.Information;
import com.pq.information.mapper.IndexBannerMapper;
import com.pq.information.mapper.InformationMapper;
import com.pq.information.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private IndexBannerMapper indexBannerMapper;
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public List<IndexBannerDto> getIndexBannerList(){
        List<IndexBanner> list = indexBannerMapper.selectList();
        List<IndexBannerDto> indexBannerList = new ArrayList<>();
        for(IndexBanner indexBanner:list){
            IndexBannerDto indexBannerDto = new IndexBannerDto();
            indexBannerDto.setId(indexBanner.getId());
            indexBannerDto.setTitle(indexBanner.getTitle());
            indexBannerDto.setPicture(indexBanner.getPicture());
            indexBannerDto.setAuthor(indexBanner.getAuthor());
            indexBannerDto.setCreatedTime(DateUtil.formatDate(indexBanner.getCreatedTime(),DateUtil.DEFAULT_DATE_FORMAT));
            indexBannerDto.setContent(indexBanner.getContent());
            indexBannerList.add(indexBannerDto);
        }
        return indexBannerList;
    }

    @Override
    public List<InformationDto> getInformationList(Integer offset,Integer size){
        List<Information> list = informationMapper.selectList(offset,size);
        List<InformationDto> informationList = new ArrayList<>();
        for(Information information:list){
            InformationDto informationDto = new InformationDto();
            informationDto.setId(information.getId());
            informationDto.setTitle(information.getTitle());
            informationDto.setImg(information.getImg());
            informationDto.setAuthor(information.getAuthor());
            informationDto.setCreatedTime(DateUtil.formatDate(information.getCreatedTime(),DateUtil.DEFAULT_DATE_FORMAT));
            informationDto.setContent(information.getContent());
            informationList.add(informationDto);
        }
        return informationList;
    }


}