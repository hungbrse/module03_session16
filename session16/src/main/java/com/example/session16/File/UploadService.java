package com.example.session16.File;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
String upload(MultipartFile file);
}
