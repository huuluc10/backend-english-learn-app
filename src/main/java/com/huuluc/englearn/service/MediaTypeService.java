package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.MediaType;
import com.huuluc.englearn.repository.MediaTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaTypeService {
    private final MediaTypeRepository mediaTypeRepository;

    public List<MediaType> getAll() {
        return mediaTypeRepository.getAll();
    }

    public MediaType getById(short mediaTypeId) {
        return mediaTypeRepository.getById(mediaTypeId);
    }

    public MediaType getByName(String mediaTypeName) {
        return mediaTypeRepository.getByName(mediaTypeName);
    }
}
