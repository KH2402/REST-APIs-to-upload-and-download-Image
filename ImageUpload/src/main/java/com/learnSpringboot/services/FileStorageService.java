package com.learnSpringboot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    public String uploadImage(MultipartFile file) throws IOException;

    public byte[] downloadImage(Long fileId);
}
