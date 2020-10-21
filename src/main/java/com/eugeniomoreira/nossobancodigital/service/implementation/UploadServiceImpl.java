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
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${zup.file.upload.path}")
    private String path;

    @Override
    public String saveFileUpload(MultipartFile file) {
        try {
            String fileLocation = path + file.getOriginalFilename() + "-" + UUID.randomUUID();
            byte[] bytes = file.getBytes();
            Path filePath = Paths.get(fileLocation);
            Files.write(filePath, bytes);

            return fileLocation;
        } catch (IOException ex) {
            throw new InternalServiceErrorException("Error file upload");
        }
    }

}
