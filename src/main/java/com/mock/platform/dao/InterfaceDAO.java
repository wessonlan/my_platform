package com.mock.platform.dao;

import com.mock.platform.pojo.Interface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wessonlan
 */
public interface InterfaceDAO extends JpaRepository<Interface, Integer> {
    /**
     * 通过接口名称查询
     * @param interfaceName 项目名称
     * @return InterfaceName
     */
    InterfaceDAO findByInterfaceName(String interfaceName);
}
