package com.zwy.accounting.dao;

import com.zwy.accounting.entity.ProjectEntity;
import com.zwy.accounting.model.response.ProjectModuleResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectEntityMapper {

    List<ProjectEntity> selectProjects();

    int insertProject(ProjectEntity projectEntity);

    ProjectEntity selectProjectByName(String name);

    ProjectEntity selectProjectById(int projectId);

    List<ProjectModuleResp> selectProjectModuleById(int projectId);

    void deleteProjectById(int projectId);

    void updateProject(ProjectEntity projectEntity);

    boolean addProjectModule(@Param("projectId") int projectId, @Param("moduleBuildId") int moduleBuildId, @Param("type") int
            type);

    boolean deleteProjectModule(@Param("projectId") int projectId, @Param("moduleBuildId") int moduleBuildId);

    Integer selectLink(@Param("projectId") int projectId, @Param("moduleBuildId") int moduleBuildId);

    boolean updateProjectModule(@Param("linkId") int linkId, @Param("projectId") int projectId, @Param("moduleBuildId") int
            moduleBuildId, @Param("type") int type);

    void updateBuildStatus(@Param("projectId") int projectId, @Param("buildStatus") int buildStatus);

    void updateIntegrateStatus(@Param("projectId") int projectId, @Param("integrateStatus") int integrateStatus);
}