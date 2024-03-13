package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.StorageFileNotFoundException;
import com.huuluc.englearn.service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
@Tag(name = "Storage", description = "Storage API")
@Slf4j
public class StorageController {
    private final StorageService storageService;
    @GetMapping("/")
    @Operation(summary = "Serve file")
    public ResponseEntity<byte[]> serveFile() throws IOException, StorageFileNotFoundException {
        log.info("Serve file");
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

//    @PostMapping("/")
//    @Operation(summary = "Upload file")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        String url = storageService.store(file);
//
//        if (url != null) {
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded " + file.getOriginalFilename() + "!");
//            //get file path file
//            String filePath = storageService.load(file.getOriginalFilename()).toString();
//            redirectAttributes.addFlashAttribute("filePath", filePath);
//        }
//        return "redirect:/";
//    }

    @PostMapping("/getfile")
    @Operation(summary = "Get file")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<byte[]> getFile(@RequestParam String path) throws IOException, StorageFileNotFoundException {
        log.info("Get file {}", path);
        Resource file = storageService.loadAsResource(path);

        if (file == null) {
            log.error("File not found");
            return ResponseEntity.notFound().build();
        }

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
