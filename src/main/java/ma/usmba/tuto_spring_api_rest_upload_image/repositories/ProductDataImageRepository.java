package ma.usmba.tuto_spring_api_rest_upload_image.repositories;

import ma.usmba.tuto_spring_api_rest_upload_image.entities.ProductDataImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDataImageRepository extends JpaRepository<ProductDataImage, Long> {
    Optional<ProductDataImage> findByProductName(String productName);
}
