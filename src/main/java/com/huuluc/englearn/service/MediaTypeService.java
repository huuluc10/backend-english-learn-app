package com.huuluc.englearn.service;

import com.huuluc.englearn.model.MediaType;

import java.util.List;

public interface MediaTypeService {
    List<MediaType> getAll();

    MediaType getById(short mediaTypeId);

    MediaType getByName(String mediaTypeName);

}
