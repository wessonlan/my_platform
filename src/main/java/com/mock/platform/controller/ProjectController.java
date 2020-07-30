package com.mock.platform.controller;


import com.mock.platform.common.Result;
import com.mock.platform.pojo.Project;
import com.mock.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

//    @GetMapping("/list")
//    public Result projectList() throws Exception {
//        List<Project> projectList = projectService.getProjectList();
//        return Result.success(projectList);
//    }

    @GetMapping("/list")
    public Result projectList(int number, int size) throws Exception {
        Page projectList = projectService.getProjectList(number, size);
        return Result.success(projectList);
    }

    @PostMapping("/list")
    public Object add(@RequestBody Project project) throws Exception {
        project.setCreateTime(new Date());
        project.setUid(1);
        project.setCreateUser("pingguo");
        projectService.add(project);
        return Result.success(project);
    }

    @PutMapping("/list")
    public Object update(@RequestBody Project project) throws Exception {
        project.setCreateTime(new Date());
        project.setUid(1);
        project.setCreateUser("pingguo");
        projectService.update(project);
        return Result.success(project);
    }

    @GetMapping("/searchProject")
    public Object searchProject(Project project, int number, int size) throws Exception {
        return Result.success(projectService.searchProject(project, number, size));
    }
}
