package com.projet.contacts.uploadingfile.controller;

import com.projet.contacts.uploadingfile.service.FileSystemStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    private FileSystemStorageService storageService;

    public FileController(FileSystemStorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(value = "/images/{filename:.+}", produces = {
            MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok(file);
    }
}
