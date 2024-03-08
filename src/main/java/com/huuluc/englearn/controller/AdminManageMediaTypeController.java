package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.MediaTypeException;
import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MediaTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
     public ResponseEntity<ResponseModel> getAll() throws MediaTypeException {
         return mediaTypeService.getAll();
     }

     @GetMapping("/{mediaTypeId}")
     @Operation(summary = "Get media type by id")
     public ResponseEntity<ResponseModel> getById(@PathVariable short mediaTypeId) throws MediaTypeException {
         return mediaTypeService.getById(mediaTypeId);
    }
}
