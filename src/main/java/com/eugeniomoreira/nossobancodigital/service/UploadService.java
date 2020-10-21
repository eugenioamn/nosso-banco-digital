package com.eugeniomoreira.nossobancodigital.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String saveFileUpload(MultipartFile file);

}
