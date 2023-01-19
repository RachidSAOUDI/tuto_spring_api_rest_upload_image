package ma.usmba.tuto_spring_api_rest_upload_image.services;

import ma.usmba.tuto_spring_api_rest_upload_image.entities.ProductFileImage;
import ma.usmba.tuto_spring_api_rest_upload_image.repositories.ProductFileImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class StorageFileService {
    private ProductFileImageRepository productFileImageRepository;

    public StorageFileService(ProductFileImageRepository productFileImageRepository) {
        this.productFileImageRepository = productFileImageRepository;
    }

    private final String FOLDER_PATH = Paths.get("").toAbsolutePath()+"/uploads/";

    public String uploadImageFileToFolder(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        productFileImageRepository.save(ProductFileImage.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath)
                .build());
        file.transferTo(new File(filePath));
        return "file uploaded successfully : " + filePath;
    }

    public byte[] downloadImageFileFromFolder(String fileName) throws Exception {
        Optional<ProductFileImage> fileImage = productFileImageRepository.findByFileName(fileName);
        String filepath = fileImage.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filepath).toPath());
        return images;
    }
}
