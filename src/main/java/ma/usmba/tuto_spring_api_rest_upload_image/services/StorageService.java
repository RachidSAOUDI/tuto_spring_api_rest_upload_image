package ma.usmba.tuto_spring_api_rest_upload_image.services;

import ma.usmba.tuto_spring_api_rest_upload_image.entities.ProductDataImage;
import ma.usmba.tuto_spring_api_rest_upload_image.repositories.ProductDataImageRepository;
import ma.usmba.tuto_spring_api_rest_upload_image.utils.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class StorageService {
    private ProductDataImageRepository productDataImageRepository;

    public StorageService(ProductDataImageRepository productDataImageRepository) {
        this.productDataImageRepository = productDataImageRepository;
    }


    public String uploadDataImage(MultipartFile file) throws Exception{
        ProductDataImage imageData = productDataImageRepository.save(ProductDataImage.builder()
                .productName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());
        if (imageData != null){
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ProductDataImage> dbImageData = productDataImageRepository.findByProductName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
