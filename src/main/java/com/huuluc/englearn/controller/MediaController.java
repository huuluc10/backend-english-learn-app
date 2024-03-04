package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/media")
public class MediaController {
    private final MediaService mediaService;

    @GetMapping("/")
    public List<Media> getAll() {
        return mediaService.getAll();
    }

    @GetMapping("/{mediaId}")
    public Media getById(@PathVariable short mediaId) {
        return mediaService.getById(mediaId);
    }
}
