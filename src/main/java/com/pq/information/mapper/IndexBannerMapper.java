package com.pq.information.mapper;

import com.pq.information.entity.IndexBanner;

import java.util.List;

public interface IndexBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexBanner record);

    IndexBanner selectByPrimaryKey(Long id);

    List<IndexBanner> selectAll();

    int updateByPrimaryKey(IndexBanner record);

    List<IndexBanner> selectList();
}