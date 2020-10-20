package com.eugeniomoreira.nossobancodigital.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    void saveFileUpload(MultipartFile file);

}
