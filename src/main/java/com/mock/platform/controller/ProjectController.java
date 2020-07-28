package com.mock.platform.controller;


import com.mock.platform.common.Result;
import com.mock.platform.pojo.Project;
import com.mock.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public Result projectList() throws Exception {
        List<Project> projectList = projectService.getProjectList();
        return Result.success(projectList);
    }

    @PutMapping("/list")
    public Object add(@RequestBody Project project) throws Exception {
        project.setCreateTime(new Date());
        project.setUid(1);
        project.setCreateUser("pingguo");
        projectService.add(project);
        return Result.success(project);
    }
}
