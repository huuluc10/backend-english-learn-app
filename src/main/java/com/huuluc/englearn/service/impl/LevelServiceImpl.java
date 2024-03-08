package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.LevelRepository;
import com.huuluc.englearn.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    @Override
    public List<Level> findAll() throws LevelException {
        return levelRepository.findAll();
    }

    @Override
    public Level findById(short level) throws LevelException {
        return levelRepository.findById(level);
    }

    @Override
    public ResponseEntity<ResponseModel> findByExp(int exp) throws LevelException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get level by exp", levelRepository.findByExp(exp));
        return ResponseEntity.ok(responseModel);
    }
}
