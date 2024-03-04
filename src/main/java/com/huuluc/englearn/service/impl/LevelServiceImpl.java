package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.repository.LevelRepository;
import com.huuluc.englearn.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    @Override
    public List<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Level findById(short level) {
        return levelRepository.findById(level);
    }

    @Override
    public Level findByExp(int exp) {
        return levelRepository.findByExp(exp);
    }
}
