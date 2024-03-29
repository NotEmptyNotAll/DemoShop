package com.example.demo.rest.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;

//import com.google.api.client.util.Value;

//@Service
public class GoogleDriveServiceImp implements GoogleDriveService {
 /*   private static final Logger LOGGER = LoggerFactory.getLogger(GoogleDriveServiceImp.class);

    @Value("${google.service_account_email}")
    private String serviceAccountEmail;

    @Value("${google.application_name}")
    private String applicationName;

    @Value("${google.service_account_key}")
    private String serviceAccountKey;

    @Value("${google.folder_id}")
    private String folderID;


    public String saveImageGDrive(MultipartFile file, boolean imageLinkDisplay) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            java.io.File convFile = new java.io.File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            com.google.api.services.drive.model.File file2 = uploadFile(UUID.randomUUID().toString() + "_" + convFile.getName(), convFile, file.getContentType());
            if (imageLinkDisplay)
                return "https://drive.google.com/uc?export=view&id=" + new JSONObject(file2.toPrettyString()).getString("id");
            else
                return new JSONObject(file2.toPrettyString()).getString("webContentLink");

        } else
            return null;
    }

    public Drive getDriveService() {
        Drive service = null;
        try {
            URL resource = GoogleDriveServiceImp.class.getResource("/" + this.serviceAccountKey);
            java.io.File key = Paths.get(resource.toURI()).toFile();
            HttpTransport httpTransport = new NetHttpTransport();
            JacksonFactory jsonFactory = new JacksonFactory();

            GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
                    .setJsonFactory(jsonFactory).setServiceAccountId(serviceAccountEmail)
                    .setServiceAccountScopes(Collections.singleton(DriveScopes.DRIVE))
                    .setServiceAccountPrivateKeyFromP12File(key).build();
            service = new Drive.Builder(httpTransport, jsonFactory, credential).setApplicationName(applicationName)
                    .setHttpRequestInitializer(credential).build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return service;
    }

    @Override
    public File uploadFile(String fileName, java.io.File fileUpload, String mimeType) {
        File file = new File();
        try {
            com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
            fileMetadata.setMimeType(mimeType);
            fileMetadata.setName(fileName);
            fileMetadata.setParents(Collections.singletonList(folderID));
            com.google.api.client.http.FileContent fileContent = new FileContent(mimeType, fileUpload);
            file = getDriveService().files().create(fileMetadata, fileContent)
                    .setFields("id,webContentLink,webViewLink").execute();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return file;
    }
    */
}
