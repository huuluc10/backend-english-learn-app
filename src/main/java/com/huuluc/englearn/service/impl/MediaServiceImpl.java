package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.MediaRepository;
import com.huuluc.englearn.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;

    @Override
    public ResponseEntity<ResponseModel> getAll() throws MediaException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all media successfully", mediaRepository.findAll());
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getById(int mediaId) throws MediaException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get media by id successfully", mediaRepository.findById(mediaId));
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public Media getByName(String mediaName) throws MediaException {
        return mediaRepository.findByName(mediaName);
    }

    @Override
    public int save(Media media) throws MediaException{
        return mediaRepository.add(media);
    }
}
