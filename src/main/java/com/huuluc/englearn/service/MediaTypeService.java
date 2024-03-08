package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MediaTypeService {
    ResponseEntity<ResponseModel> getAll() throws MediaTypeException;

    ResponseEntity<ResponseModel> getById(short mediaTypeId) throws MediaTypeException;


}
