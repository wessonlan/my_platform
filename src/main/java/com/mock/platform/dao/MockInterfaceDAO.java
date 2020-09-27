package com.mock.platform.dao;

import com.mock.platform.pojo.MockInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wessonlan
 */
public interface MockInterfaceDAO extends JpaRepository<MockInterface, Integer> {
    /**
     * 通过接口名称查询
     * @param interfaceName 项目名称
     * @return InterfaceName
     */
    MockInterfaceDAO findByInterfaceName(String interfaceName);
}
