package com.jack.hospital.dao;

import com.jack.hospital.entity.Depclass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("depclassDao")
public interface DepclassDao {
    void insert(Depclass depclass);
    void delete(Integer id);
    void update(Depclass depclass);
    List<Depclass> findAll();
    Depclass findById(Integer id);
}
