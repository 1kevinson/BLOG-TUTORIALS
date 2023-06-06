package com.example.demo.e2e;

import com.example.entity.Image;
import com.example.repository.ImageRepository;
import com.example.util.ImageUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ImageControllerTest extends BaseE2E {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ImageRepository imageRepository;

    @BeforeEach
    void setUp() {
        imageRepository.deleteAll();
    }

    @Test
    @Order(1)
    void should_upload_an_image_in_database() throws Exception {
        // Given
        MockMultipartFile file = new MockMultipartFile(
                "image",
                "mock-image.png",
                MediaType.IMAGE_PNG_VALUE,
                new byte[ImageUtils.BITE_SIZE]
        );

        // When
        var requestBuilder = MockMvcRequestBuilders.multipart("/image").file(file);

        // Then
        mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andDo(print());
        imageRepository.findById(1L).ifPresent(user -> {
            assertThat(user.getName()).isEqualTo("mock-image.png");
            assertThat(user.getType()).isEqualTo("image/png");
            assertThat(user.getImageData()).isInstanceOf(byte[].class);
        });
    }

    @Test
    @Order(2)
    void should_download_an_image_from_database() throws Exception {
        // Given
        imageRepository.saveAll(imagesInDatabase());

        // When
        var requestBuilder = MockMvcRequestBuilders.get("/image/e2e-test-image.png");

        // Then
        mockMvc.perform(requestBuilder.accept(MediaType.IMAGE_JPEG_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private List<Image> imagesInDatabase() {
        return Stream.of(
    Image.builder().id(1L).name("e2e-test-image1.png").type("image/png").imageData(new byte[ImageUtils.BITE_SIZE]).build(),
            Image.builder().id(2L).name("e2e-test-image2.jpg").type("image/jpg").imageData(new byte[ImageUtils.BITE_SIZE]).build()
        ).toList();
    }
}
