package com.mock.platform.controller;

import com.mock.platform.common.MpException;
import com.mock.platform.common.Result;
import com.mock.platform.pojo.MockInterface;
import com.mock.platform.pojo.Project;
import com.mock.platform.service.MockInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author wessonlan
 */
@RestController
@RequestMapping(value = "/interface")
public class MockInterfaceController {
    @Autowired
    MockInterfaceService mockInterfaceService;

    @GetMapping("/list")
    public Result projectList(int number, int size) throws Exception {
        Page InterfaceList = mockInterfaceService.getInterfaceList(number, size);
        return Result.success(InterfaceList);
    }

    @PostMapping("/list")
    public Object add(@RequestBody MockInterface mockInterface) throws Exception {
        mockInterface.setCreateTime(new Date());
        mockInterface.setCreateUser("pingguo");
        mockInterfaceService.add(mockInterface);
        return Result.success();
    }
}
