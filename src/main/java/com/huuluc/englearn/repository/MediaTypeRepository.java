package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.mapper.MediaTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MediaTypeRepository {
    MediaTypeMapper mediaTypeMapper;

    @Autowired
    public MediaTypeRepository(MediaTypeMapper mediaTypeMapper) {
        this.mediaTypeMapper = mediaTypeMapper;
    }

    public List<MediaType> getAll() throws MediaTypeException {
        return mediaTypeMapper.findAll();
    }

    public MediaType getById(short mediaTypeId) throws MediaTypeException {
        return mediaTypeMapper.findById(mediaTypeId);
    }

}
