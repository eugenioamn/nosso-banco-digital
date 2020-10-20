package com.eugeniomoreira.nossobancodigital.api;

import com.eugeniomoreira.nossobancodigital.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file")
public class FileUpload {

    private final UploadService uploadService;

    public FileUpload(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) {
        uploadService.saveFileUpload(file);
    }

}
