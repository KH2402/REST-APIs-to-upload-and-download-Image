package com.learnSpringboot.controllers;

import com.learnSpringboot.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    //upload image api (save image api)
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadImage = this.fileStorageService.uploadImage(file);
        return new ResponseEntity<>(uploadImage,HttpStatus.OK);
    }

    //download image api( get image api)
    @GetMapping("/{fileId}")
    public ResponseEntity<?>  downloadImage(@PathVariable Long fileId){

        byte[] imageData = this.fileStorageService.downloadImage(fileId);

        //return new ResponseEntity<>(imageData, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }
}
