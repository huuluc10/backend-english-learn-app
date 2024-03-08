package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.exception.StorageException;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.mapper.MediaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MediaRepository {
    private final MediaMapper mediaMapper;

    public List<Media> findAll() throws MediaException {
        return mediaMapper.findAll();
    }

    public Media findById(int mediaId) throws MediaException {
        return mediaMapper.findById(mediaId);
    }

    public Media findByName(String mediaName) throws MediaException {
        return mediaMapper.findByName(mediaName);
    }

    public int add(Media media) throws MediaException {
        return mediaMapper.add(media);
    }
}
