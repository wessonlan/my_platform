package com.mock.platform.service;

import com.mock.platform.dao.ProjectDAO;
import com.mock.platform.pojo.Project;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    public Page<Project> searchProject(Project project, int number, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(number - 1, size , sort);
        Specification<Project> query = new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (project.getId() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("id"), project.getId()));
                }
                if (StringUtils.isNotEmpty(project.getProjectName())) {
                    predicates.add(criteriaBuilder.like(root.get("projectName"), "%" + project.getProjectName() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        return projectDAO.findAll(query, pageable);
    }

}
