package com.learnSpringboot.services.impl;

import com.learnSpringboot.entities.ImageData;
import com.learnSpringboot.repositories.FileStorageRepo;
import com.learnSpringboot.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileStorageRepo fileStorageRepo;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData=new ImageData();
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());
        imageData.setImageData(file.getBytes());


        ImageData imageData1=this.fileStorageRepo.save(imageData);

        if (imageData1!=null){
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public byte[] downloadImage(Long fileId) {
        Optional<ImageData> dbImageData= this.fileStorageRepo.findById(fileId);

        byte[] imageData=dbImageData.get().getImageData();
        return imageData;
    }
}
