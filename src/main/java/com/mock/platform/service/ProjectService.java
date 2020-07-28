package com.mock.platform.service;

import com.mock.platform.dao.ProjectDAO;
import com.mock.platform.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectDAO projectDAO;

    public List<Project> getProjectList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return projectDAO.findAll(sort);
    }

    public void add(Project project) {
        projectDAO.save(project);
    }

    public void update(Project project) {
        projectDAO.save(project);
    }

}
