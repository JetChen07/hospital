package com.jack.hospital.service.impl;

import com.jack.hospital.dao.DepclassDao;
import com.jack.hospital.entity.Depclass;
import com.jack.hospital.service.DepclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("depclassService")
public class DepclassServiceImpl implements DepclassService {

    @Autowired
    private DepclassDao depclassDao;

    public void insert(Depclass depclass) {
        depclassDao.insert(depclass);
    }

    public void delete(Integer id) {
        depclassDao.delete(id);
    }

    public void update(Depclass depclass) {
        depclassDao.update(depclass);
    }

    public List<Depclass> findAll() {
        return depclassDao.findAll();
    }

    public Depclass findById(Integer id) {
        return depclassDao.findById(id);
    }
}
