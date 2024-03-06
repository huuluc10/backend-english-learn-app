package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.MediaType;
import com.huuluc.englearn.service.MediaTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/media-types")
@RequiredArgsConstructor
public class MediaTypeController {
     private final MediaTypeService mediaTypeService;

     @GetMapping("/")
     public List<MediaType> getAll() {
         return mediaTypeService.getAll();
     }

     @GetMapping("/{mediaTypeId}")
     public MediaType getById(@PathVariable short mediaTypeId) {
         return mediaTypeService.getById(mediaTypeId);
    }
}
