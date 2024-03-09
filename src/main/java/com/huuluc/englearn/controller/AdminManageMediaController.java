package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MediaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/manage/media")
@RequiredArgsConstructor
@Tag(name = "Admin Manage Media", description = "Admin API Manage Media")
@Slf4j
public class AdminManageMediaController {
    private final MediaService mediaService;
    private final MediaController mediaController;

    @GetMapping("/")
    @Operation(summary = "Get all media")
    public ResponseEntity<ResponseModel> getAll() throws MediaException {
        log.info("Admin: Get all media");
        return mediaService.getAll();
    }

    @GetMapping("/{mediaId}")
    @Operation(summary = "Get media by id")
    public ResponseEntity<ResponseModel> getById(@PathVariable short mediaId) throws MediaException {
        log.info("Admin: Get media by id {}", mediaId);
        return mediaController.getById(mediaId);
    }
}
