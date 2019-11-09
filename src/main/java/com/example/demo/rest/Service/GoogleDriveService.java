package com.example.demo.rest.Service;


import com.google.api.services.drive.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoogleDriveService {

    public File uploadFile(String fileName, java.io.File fileUpload,String mimeType);

    public String saveImageGDrive(MultipartFile file, boolean imageLinkDisplay) throws IOException;
}
