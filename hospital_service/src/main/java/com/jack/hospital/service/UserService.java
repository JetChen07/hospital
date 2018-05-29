package com.jack.hospital.service;

import com.jack.hospital.entity.User;

public interface UserService {
    User login(String account, String password);
}
