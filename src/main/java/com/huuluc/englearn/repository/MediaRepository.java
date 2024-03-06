package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.mapper.MediaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MediaRepository {
    private final MediaMapper mediaMapper;

    public List<Media> findAll() {
        return mediaMapper.findAll();
    }

    public Media findById(int mediaId) {
        return mediaMapper.findById(mediaId);
    }

    public Media findByName(String mediaName) {
        return mediaMapper.findByName(mediaName);
    }
}
