package com.example.service;

import com.example.entity.Image;
import com.example.repository.ImageRepository;
import com.example.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = Image.builder()
                .name(imageFile.getOriginalFilename())
                .type(imageFile.getContentType())
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();

        imageRepository.save(imageToSave);
        return "file uploaded successfully : " + imageFile.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName) {
        Optional<Image> dbImageData = imageRepository.findByName(imageName);
        return dbImageData.map(image -> ImageUtils.decompressImage(image.getImageData())).orElse(null);
    }
}
