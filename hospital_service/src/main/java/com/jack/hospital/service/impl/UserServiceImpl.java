package com.jack.hospital.service.impl;

import com.jack.hospital.dao.UserDao;
import com.jack.hospital.entity.User;
import com.jack.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User login(String account, String password) {
        User user = userDao.findByAccount(account);
        if(user!=null && user.getPassword().equals(password)) {
            return user;
        }else{
            return null;
        }
    }
}
