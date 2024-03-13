package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;

public interface StorageService {
    void init();

    String store(MultipartFile file, String folderName, String newFileName);

    Path load(String filename);

    Resource loadAsResource(String filename) throws StorageFileNotFoundException, MalformedURLException;



}
