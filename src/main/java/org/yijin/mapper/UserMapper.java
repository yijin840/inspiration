package org.yijin.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import org.yijin.entity.User;

import java.util.List;

/**
 * @author YiJin840
 * @program inspiration
 * @description user mapper
 * @since 2024-03-04 12:08
 **/
@Repository
@Mapper
public interface UserMapper {

    List<User> getAllUsers();

    void insertUser(User user);

    User findById(Long id);

}
