package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.MediaType;

import java.util.List;

public interface MediaTypeService {
    List<MediaType> getAll();

    MediaType getById(short mediaTypeId);

    MediaType getByName(String mediaTypeName);

}
