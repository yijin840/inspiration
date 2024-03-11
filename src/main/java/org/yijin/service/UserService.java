package org.yijin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yijin.entity.User;
import org.yijin.mapper.UserMapper;

import java.util.List;

/**
 * @author YiJin840
 * @program inspiration
 * @description user service
 * @since 2024-03-02 14:38
 **/
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

        public List<User> getAllUser() {
            return userMapper.getAllUsers();
        }

        public User findById(Long id) {
            return userMapper.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }



}
