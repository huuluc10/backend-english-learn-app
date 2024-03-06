package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.mapper.LevelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LevelRepository {
    private final LevelMapper levelMapper;

    public List<Level> findAll() {
        return levelMapper.findAll();
    }

    public Level findById(short level) {
        return levelMapper.findById(level);
    }

    public Level findByExp(int exp) {
        return levelMapper.findByExp(exp);
    }
}
