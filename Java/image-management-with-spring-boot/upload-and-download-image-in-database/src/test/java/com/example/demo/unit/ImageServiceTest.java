package com.example.demo.unit;

import com.example.entity.Image;
import com.example.repository.ImageRepository;
import com.example.service.ImageService;
import com.example.util.ImageUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.example.util.ImageUtils.BITE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ImageServiceTest {

    @InjectMocks
    private ImageService imageService;

    @Mock
    private ImageRepository imageRepository;

    @Test
    @SneakyThrows
    public void should_upload_image() {
        try (MockedStatic<ImageUtils> mockedImageUtils = mockStatic(ImageUtils.class)) {
            // Arrange
            Image imageUploaded = new Image();
            MultipartFile imageFile = new MockMultipartFile("file", "test-image.png", IMAGE_PNG_VALUE, new byte[BITE_SIZE]);
            when(imageRepository.save(any(Image.class))).thenReturn(imageUploaded);
            mockedImageUtils.when(() -> ImageUtils.compressImage(isA(byte[].class))).thenReturn(isA(byte[].class));

            // Act
            String expected = "file uploaded successfully : test-image.png";
            String actual = imageService.uploadImage(imageFile);

            // Assert
            assertThat(expected).isEqualTo(actual);
            mockedImageUtils.verify(() -> ImageUtils.compressImage(isA(byte[].class)), times(1));
            mockedImageUtils.verifyNoMoreInteractions();
            verify(imageRepository, times(1)).save(any(Image.class));
            verifyNoMoreInteractions(imageRepository);
        }
    }

    @Test
    @SneakyThrows
    public void should_download_image() {
        try (MockedStatic<ImageUtils> mockedImageUtils = mockStatic(ImageUtils.class)) {
            // Arrange
            var imageData = new byte[BITE_SIZE];
            String imageName = "random-img.png";
            Image imageEntity = Image.builder().imageData(imageData).name(imageName).id(2L).build();
            Optional<Image> imageInDatabase = Optional.of(imageEntity);

            when(imageRepository.findByName(anyString())).thenReturn(imageInDatabase);
            mockedImageUtils.when(() -> ImageUtils.decompressImage(isA(byte[].class))).thenReturn(imageData);

            // Act
            byte[] actual = imageService.downloadImage(imageName);

            // Assert
            assertArrayEquals(imageData, actual);
            mockedImageUtils.verify(() -> ImageUtils.decompressImage(isA(byte[].class)), times(1));
            mockedImageUtils.verifyNoMoreInteractions();
            verify(imageRepository, times(1)).findByName(anyString());
            verifyNoMoreInteractions(imageRepository);
        }
    }
}
