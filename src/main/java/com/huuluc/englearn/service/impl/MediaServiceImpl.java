package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.Media;
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
        return mediaRepository.getAll();
    }

    @Override
    public Media getById(short mediaId) {
        return mediaRepository.getById(mediaId);
    }

    @Override
    public Media getByName(String mediaName) {
        return mediaRepository.getByName(mediaName);
    }
}
