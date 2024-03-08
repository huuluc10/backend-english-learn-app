package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelService {
    List<Level> findAll() throws LevelException;

    Level findById(short level) throws LevelException;

    ResponseEntity<ResponseModel> findByExp(int exp) throws LevelException;
}
