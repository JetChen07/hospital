package com.jack.hospital.service;

import com.jack.hospital.entity.Depclass;

import java.util.List;

public interface DepclassService {
    void insert(Depclass depclass);
    void delete(Integer id);
    void update(Depclass depclass);
    List<Depclass> findAll();
    Depclass findById(Integer id);
}
