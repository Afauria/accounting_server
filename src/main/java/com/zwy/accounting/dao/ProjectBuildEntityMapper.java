package com.zwy.accounting.dao;

import com.zwy.accounting.entity.ProjectBuildEntity;

import java.util.List;

public interface ProjectBuildEntityMapper {
    int insert(ProjectBuildEntity record);

    List<ProjectBuildEntity> selectProjectBuilds(int projectId);

    ProjectBuildEntity selectProjectBuildById(int projectBuildId);
}