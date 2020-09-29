package com.mock.platform.controller;

import com.mock.platform.common.Result;
import com.mock.platform.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rule")
/**
 * @author wessonlan
 */
public class RuleController {
    @Autowired
    RuleService ruleService;

    @GetMapping("/list")
    public Result ruleList(int number, int size) throws Exception {
        Page ruleList = ruleService.getRuleList(number, size);
        return Result.success(ruleList);
    }
}
