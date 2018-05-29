package com.jack.hospital.dao;

import com.jack.hospital.entity.Department;
import com.jack.hospital.entity.Depclass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    List<Department> findAll();
    Department findById(Integer id);
    Department findByClass(Integer id);
}
