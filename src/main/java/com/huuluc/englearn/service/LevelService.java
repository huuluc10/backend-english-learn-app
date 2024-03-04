package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Level;

import java.util.List;

public interface LevelService {
    List<Level> findAll();

    public Level findById(short level);

    public Level findByExp(int exp);
}
