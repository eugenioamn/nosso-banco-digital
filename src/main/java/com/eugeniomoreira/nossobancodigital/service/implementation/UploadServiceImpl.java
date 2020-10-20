package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.exception.InternalServiceErrorException;
import com.eugeniomoreira.nossobancodigital.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${zup.file.upload.path}")
    private String path;

    @Override
    public void saveFileUpload(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path filePath = Paths.get(path + file.getOriginalFilename());
            Files.write(filePath, bytes);
        } catch (IOException ex) {
            throw new InternalServiceErrorException("Error file upload");
        }
    }
}
