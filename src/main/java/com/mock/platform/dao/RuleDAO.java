package com.mock.platform.dao;

import com.mock.platform.pojo.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wessonlan
 */
public interface RuleDAO extends JpaRepository<Rule, Integer> {
}
