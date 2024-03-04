package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.StorageProperties;
import com.huuluc.englearn.exception.StorageException;
import com.huuluc.englearn.exception.StorageFileNotFoundException;
import com.huuluc.englearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {

        if(properties.getLocation().trim().length() == 0){
            throw new StorageException("File upload location can not be Empty.");
        }

//        properties.setLocation("data");

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get( file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            String rootPath = this.rootLocation.toAbsolutePath().toString();
            String destinationPath = destinationFile.toString();
            if (!destinationPath.contains(rootPath)) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file. " + e.getMessage());
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String url) {
        try {
            Path file = load(url);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + url);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + url, e);
        }
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
