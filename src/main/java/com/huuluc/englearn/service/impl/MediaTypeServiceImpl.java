package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.MediaTypeRepository;
import com.huuluc.englearn.service.MediaTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MediaTypeServiceImpl implements MediaTypeService {
    private final MediaTypeRepository mediaTypeRepository;

    @Override
    public ResponseEntity<ResponseModel> getAll() throws MediaTypeException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all media types successfully", mediaTypeRepository.getAll());
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getById(short mediaTypeId) throws MediaTypeException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get media type by id successfully", mediaTypeRepository.getById(mediaTypeId));
        return ResponseEntity.ok(responseModel);
    }

}
