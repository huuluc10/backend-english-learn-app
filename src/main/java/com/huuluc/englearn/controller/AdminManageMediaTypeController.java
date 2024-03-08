package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.service.MediaTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/v1/manage/media-type")
@RequiredArgsConstructor
@Tag(name = "Admin Manage Media Type", description = "Admin API Manage Media Type")
public class AdminManageMediaTypeController {
     private final MediaTypeService mediaTypeService;

     @GetMapping("/")
     @Operation(summary = "Get all media types")
     public List<MediaType> getAll() {
         return mediaTypeService.getAll();
     }

     @GetMapping("/{mediaTypeId}")
     @Operation(summary = "Get media type by id")
     public MediaType getById(@PathVariable short mediaTypeId) {
         return mediaTypeService.getById(mediaTypeId);
    }
}