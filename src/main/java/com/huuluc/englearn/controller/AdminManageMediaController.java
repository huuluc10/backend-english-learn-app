package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MediaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/manage/media")
@RequiredArgsConstructor
@Tag(name = "Admin Manage Media", description = "Admin API Manage Media")
public class AdminManageMediaController {
    private final MediaService mediaService;
    private final MediaController mediaController;

    @GetMapping("/")
    @Operation(summary = "Get all media")
    public ResponseEntity<ResponseModel> getAll() throws MediaException {
        return mediaService.getAll();
    }

    @GetMapping("/{mediaId}")
    @Operation(summary = "Get media by id")
    public ResponseEntity<ResponseModel> getById(@PathVariable short mediaId) throws MediaException {
        return mediaController.getById(mediaId);
    }
}
