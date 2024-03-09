package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface MediaService {
    ResponseEntity<ResponseModel> getAll() throws MediaException;

    ResponseEntity<ResponseModel> getById(int mediaId) throws MediaException;

    Media getByName(String mediaName) throws MediaException;

    int save(Media media) throws MediaException;
}
