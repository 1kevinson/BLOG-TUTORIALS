package com.example.demo.integration;

import com.example.entity.Image;
import com.example.repository.ImageRepository;
import com.example.util.ImageUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JPAImageRepositoryTest extends BaseIntegrationTest {

    @Autowired
    private ImageRepository imageRepository;
    private static Image imageFixture;

    @BeforeEach
    void setUp() {
        imageFixture = Image.builder()
                .id(1L)
                .name("integration-test-image.png")
                .type("image/png")
                .imageData(new byte[ImageUtils.BITE_SIZE])
                .build();
        imageRepository.save(imageFixture);
    }

    @Test
    @Order(1)
    void can_upload_an_image_in_database() {
        // Arrange & Act
        List<Image> imageList = imageRepository.findAll();

        // Assert
        assertThat(imageList).hasSize(1);
        assertThat(imageList.get(0))
                .usingRecursiveComparison()
                .isEqualTo(imageFixture);
    }

    @Test
    @Order(2)
    void can_download_an_image_from_database() {
        // Arrange
        String nameOfImageToDownload = imageFixture.getName();

        // Act & Assert
        Optional<Image> imageDownloaded = imageRepository.findByName(nameOfImageToDownload);
        assertThat(imageDownloaded).isPresent()
                .map(Image::getId)
                .get().isEqualTo(2L);
        assertThat(imageDownloaded)
                .isPresent()
                .get()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(imageFixture);
    }
}
