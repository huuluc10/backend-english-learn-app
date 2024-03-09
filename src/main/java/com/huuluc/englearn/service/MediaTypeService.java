package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface MediaTypeService {
    ResponseEntity<ResponseModel> getAll() throws MediaTypeException;

    ResponseEntity<ResponseModel> getById(short mediaTypeId) throws MediaTypeException;


}
