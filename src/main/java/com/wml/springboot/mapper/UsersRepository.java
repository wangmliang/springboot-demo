package com.wml.springboot.mapper;

import com.wml.springboot.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * data-jpa 接口实例
 * <pre>
 * <b>Title：</b>UsersRepository.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 11:32<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public interface UsersRepository extends JpaRepository<UserJpa, Long> {

    UserJpa findByName(String name);
    UserJpa findByNameAndAge(String name, Integer age);
    @Query("from UserJpa u where u.name=:name")
    UserJpa findUser(@Param("name") String name);
}
