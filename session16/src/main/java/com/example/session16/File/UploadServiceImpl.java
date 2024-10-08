package com.example.session16.File;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String upload(MultipartFile img) {
        String uploadPath = "C:\\Users\\Amin\\Desktop\\module03\\session16\\src\\main\\webapp\\uploads";
        System.out.println(uploadPath);
        File file1 = new File(uploadPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        // lấy tên file gốc
        String fileImage = img.getOriginalFilename();
        //System.out.println(fileImage);
        // copy file upload lên gửi vo thư mục uploads
        try {
            FileCopyUtils.copy(img.getBytes(),new File(uploadPath+File.separator+fileImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileImage;
    }
}
