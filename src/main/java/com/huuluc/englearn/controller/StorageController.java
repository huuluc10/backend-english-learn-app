package com.huuluc.englearn.controller;

import com.huuluc.englearn.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;
    @GetMapping("/")
    public ResponseEntity<byte[]> serveFile() throws IOException {
        String filename = "images/launcher/logo.png";
        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        String mimeType;

        try {
            mimeType = Files.probeContentType(Paths.get(file.getURI()));
        } catch (IOException e) {
            mimeType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .body(FileUtils.readFileToByteArray(file.getFile()));
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        //get file path file
        String filePath = storageService.load(file.getOriginalFilename()).toString();
        redirectAttributes.addFlashAttribute("filePath", filePath);

        return "redirect:/";
    }

    @PostMapping("/getfile")
    public ResponseEntity<byte[]> getFile(@RequestParam String path) throws IOException {
        Resource file = storageService.loadAsResource(path);

        if (file == null)
            return ResponseEntity.notFound().build();

        String mimeType;

        try {
            mimeType = Files.probeContentType(Paths.get(file.getURI()));
        } catch (IOException e) {
            mimeType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .body(FileUtils.readFileToByteArray(file.getFile()));
    }
}
