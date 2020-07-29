package com.mock.platform.service;

import com.mock.platform.dao.ProjectDAO;
import com.mock.platform.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectDAO projectDAO;

//    public List<Project> getProjectList() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        return projectDAO.findAll(sort);
//    }

    public Page<Project> getProjectList(int number, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(number - 1, size, sort);
        return projectDAO.findAll(pageable);
    }

    public void add(Project project) {
        projectDAO.save(project);
    }

    public void update(Project project) {
        projectDAO.save(project);
    }

}
