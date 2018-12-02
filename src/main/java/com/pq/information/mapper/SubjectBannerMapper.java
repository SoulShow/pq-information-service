package com.pq.information.mapper;

import com.pq.information.entity.SubjectBanner;

import java.util.List;

public interface SubjectBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubjectBanner record);

    SubjectBanner selectByPrimaryKey(Long id);

    List<SubjectBanner> selectAll();

    int updateByPrimaryKey(SubjectBanner record);

    List<SubjectBanner> selectValid();

}