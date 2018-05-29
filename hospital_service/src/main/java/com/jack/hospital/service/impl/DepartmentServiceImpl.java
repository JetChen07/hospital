package com.jack.hospital.service.impl;

import com.jack.hospital.dao.DepartmentDao;
import com.jack.hospital.entity.Department;
import com.jack.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    public void insert(Department department) {
        departmentDao.insert(department);
    }

    public void delete(Integer id) {
        departmentDao.delete(id);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    public Department findByClass(Integer id){
        return departmentDao.findByClass(id);
    }
}
