package com.mock.platform.controller;


import com.mock.platform.common.MpException;
import com.mock.platform.common.Result;
import com.mock.platform.pojo.Project;
import com.mock.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/project")
/**
 * @author wessonlan
 */
public class ProjectController {

    @Autowired
    ProjectService projectService;

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
        try {
            projectService.add(project);
            return Result.success(project);
        } catch (MpException e) {
            return Result.fail(Result.ALREADY_EXIST_CODE, String.format("%s已存在", project.getProjectName()));
        }
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
        try {
            return Result.success(projectService.searchProject(project, number, size));
        } catch (MpException e) {
            return Result.fail(Result.INPUT_EMPTY, "项目名称不能为空");
        }
    }
}
