package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Level;
import com.huuluc.englearn.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;

    public List<Level> findAll() {
        return levelRepository.findAll();
    }

    public Level findById(short level) {
        return levelRepository.findById(level);
    }

    public Level findByExp(int exp) {
        return levelRepository.findByExp(exp);
    }
}
