package com.jack.hospital.service;

import com.jack.hospital.entity.Department;

import java.util.List;

public interface DepartmentService {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    List<Department> findAll();
    Department findById(Integer id);
    Department findByClass(Integer id);
}
