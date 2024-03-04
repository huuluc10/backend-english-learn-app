package com.huuluc.englearn.service;

import com.huuluc.englearn.model.Media;

import java.util.List;

public interface MediaService {
    List<Media> getAll();

    Media getById(short mediaId);

    Media getByName(String mediaName);
}
