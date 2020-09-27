package com.mock.platform.service;

import com.mock.platform.dao.MockInterfaceDAO;
import com.mock.platform.pojo.MockInterface;
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
public class MockInterfaceService {
    @Autowired
    MockInterfaceDAO mockInterfaceDAO;

    public Page<MockInterface> getInterfaceList(int number, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(number - 1, size, sort);
        return mockInterfaceDAO.findAll(pageable);
    }

    public void add(MockInterface mockInterface) {
        mockInterfaceDAO.save(mockInterface);
    }

}
