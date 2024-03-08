package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.repository.MediaRepository;
import com.huuluc.englearn.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;

    @Override
    public List<Media> getAll() {
        return mediaRepository.findAll();
    }

    @Override
    public Media getById(int mediaId) {
        return mediaRepository.findById(mediaId);
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
