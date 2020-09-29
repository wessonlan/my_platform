package com.mock.platform.service;

import com.mock.platform.dao.RuleDAO;
import com.mock.platform.pojo.MockInterface;
import com.mock.platform.pojo.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author wessonlan
 */
@Service
public class RuleService {
    @Autowired
    RuleDAO ruleDAO;

    public Page<Rule> getRuleList(int number, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(number - 1, size, sort);
        return ruleDAO.findAll(pageable);
    }
}
