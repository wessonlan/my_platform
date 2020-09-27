package com.mock.platform.dao;

import com.mock.platform.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wessonlan
 */
public interface ProjectDAO extends JpaRepository<Project, Integer>, JpaSpecificationExecutor {
    /**
     * 通过项目名称查询
     * @param projectName 项目名称
     * @return Project
     */
    Project findByProjectName(String projectName);
}
