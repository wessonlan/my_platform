package com.mock.platform.dao;

import com.mock.platform.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectDAO extends JpaRepository<Project, Integer>, JpaSpecificationExecutor {

}
