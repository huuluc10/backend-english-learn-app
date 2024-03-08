package com.huuluc.englearn.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    String store(MultipartFile file, String folderName, String newFileName);

    Path load(String filename);

    Resource loadAsResource(String filename);



}
