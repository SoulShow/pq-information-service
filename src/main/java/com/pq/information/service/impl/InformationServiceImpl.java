package com.pq.information.service.impl;

import com.pq.common.util.DateUtil;
import com.pq.information.dto.*;
import com.pq.information.entity.IndexBanner;
import com.pq.information.entity.Information;
import com.pq.information.entity.Subject;
import com.pq.information.entity.SubjectBanner;
import com.pq.information.exception.InformationErrors;
import com.pq.information.exception.InformationException;
import com.pq.information.mapper.IndexBannerMapper;
import com.pq.information.mapper.InformationMapper;
import com.pq.information.mapper.SubjectBannerMapper;
import com.pq.information.mapper.SubjectMapper;
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
    @Autowired
    private SubjectBannerMapper subjectBannerMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public List<IndexBannerDto> getIndexBannerList(){
        List<IndexBanner> list = indexBannerMapper.selectList();
        List<IndexBannerDto> indexBannerList = new ArrayList<>();
        for(IndexBanner indexBanner:list){
            IndexBannerDto indexBannerDto = new IndexBannerDto();
            indexBannerDto.setId(indexBanner.getId());
            indexBannerDto.setPicture(indexBanner.getPicture());
            indexBannerList.add(indexBannerDto);
        }
        return indexBannerList;
    }

    @Override
    public IndexBannerDetailDto getIndexBannerById(Long id){
        IndexBanner indexBanner = indexBannerMapper.selectByPrimaryKey(id);
        if(indexBanner==null){
            InformationException.raise(InformationErrors.INDEX_BANNER_IS_NOT_EXIST);
        }
        IndexBannerDetailDto indexBannerDetailDto = new IndexBannerDetailDto();
        indexBannerDetailDto.setId(indexBanner.getId());
        indexBannerDetailDto.setPicture(indexBanner.getPicture());
        indexBannerDetailDto.setContent(indexBanner.getContent());
        indexBannerDetailDto.setTitle(indexBanner.getTitle());
        indexBannerDetailDto.setAuthor(indexBanner.getAuthor());
        indexBannerDetailDto.setCreatedTime(DateUtil.formatDate(indexBanner.getCreatedTime(),DateUtil.DEFAULT_DATE_FORMAT));
        return indexBannerDetailDto;
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

    @Override
    public SubjectBannerDto getSubjectBanner(){
        List<SubjectBanner> bannerList = subjectBannerMapper.selectValid();

        List<Subject> subjectList = subjectMapper.selectValid(0,1);

        SubjectBannerDto subjectBannerDto = new SubjectBannerDto();
        if(bannerList!=null&&bannerList.size()>0){
            subjectBannerDto.setImg(bannerList.get(0).getImg());
            subjectBannerDto.setId(bannerList.get(0).getId());
        }
        if(subjectList!=null&&subjectList.size()>0){
            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setId(subjectList.get(0).getId());subjectDto.setTag(subjectList.get(0).getTag());
            subjectDto.setTitle(subjectList.get(0).getTitle());subjectDto.setUrl(subjectList.get(0).getUrl());
            subjectBannerDto.setSubject(subjectDto);
        }
        return subjectBannerDto;
    }

    @Override
    public List<SubjectDto> getSubjectList(int offset,int size){
        List<Subject> subjectList = subjectMapper.selectValid(offset,size);
        List<SubjectDto> list = new ArrayList<>();
        for(Subject subject : subjectList){
            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setId(subject.getId());
            subjectDto.setTitle(subject.getTitle());
            subjectDto.setTag(subject.getTag());
            subjectDto.setUrl(subject.getUrl());
            subjectDto.setCreateTime(DateUtil.formatDate(subject.getCreatedTime(),DateUtil.DEFAULT_DATETIME_FORMAT));
            list.add(subjectDto);
        }
        return list;
    }



}
