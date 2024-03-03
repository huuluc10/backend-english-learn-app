package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Media;
import com.huuluc.englearn.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;

    public List<Media> getAll() {
        return mediaRepository.getAll();
    }

    public Media getById(short mediaId) {
        return mediaRepository.getById(mediaId);
    }

    public Media getByName(String mediaName) {
        return mediaRepository.getByName(mediaName);
    }
}
