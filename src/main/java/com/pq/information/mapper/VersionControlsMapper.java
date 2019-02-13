package com.pq.information.mapper;

import com.pq.information.entity.VersionControls;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VersionControlsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VersionControls record);

    VersionControls selectByPrimaryKey(Long id);

    List<VersionControls> selectAll();

    int updateByPrimaryKey(VersionControls record);

    VersionControls findLatest(@Param("client") int client,@Param("platform") int platform);

    Integer findEverForceUpdatedByVersionCode(@Param("client") int client, @Param("versionNo") String versionNo,
                                              @Param("platform") int platform);
}