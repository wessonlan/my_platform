package com.mock.platform.dao;

import com.mock.platform.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserDAO类继承JpaRepository，就提供了CRUD和分页 的各种常见功能。
 * JpaRepository<User, Integer>,参数分别是实体类，和这个实体类id的类型。
 */
public interface UserDAO extends JpaRepository<User, Integer> {

}
