package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.repository.MediaTypeRepository;
import com.huuluc.englearn.service.MediaTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaTypeServiceImpl implements MediaTypeService {
    private final MediaTypeRepository mediaTypeRepository;

    @Override
    public List<MediaType> getAll() {
        return mediaTypeRepository.getAll();
    }

    @Override
    public MediaType getById(short mediaTypeId) {
        return mediaTypeRepository.getById(mediaTypeId);
    }

    @Override
    public MediaType getByName(String mediaTypeName) {
        return mediaTypeRepository.getByName(mediaTypeName);
    }
}
