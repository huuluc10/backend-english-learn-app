package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.service.MediaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/media")
@Tag(name = "Media", description = "Media API")
public class MediaController {
    private final MediaService mediaService;

    @GetMapping("/")
    @Operation(summary = "Get all media")
    public List<Media> getAll() {
        return mediaService.getAll();
    }

    @GetMapping("/{mediaId}")
    @Operation(summary = "Get media by id")
    public Media getById(@PathVariable short mediaId) {
        return mediaService.getById(mediaId);
    }
}
