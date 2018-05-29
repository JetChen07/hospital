package com.jack.hospital.dao;

import com.jack.hospital.entity.Depclass;
import com.jack.hospital.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    User findByAccount(String account);
}
