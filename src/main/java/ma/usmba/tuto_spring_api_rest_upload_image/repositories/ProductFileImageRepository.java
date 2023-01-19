package ma.usmba.tuto_spring_api_rest_upload_image.repositories;

import ma.usmba.tuto_spring_api_rest_upload_image.entities.ProductFileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFileImageRepository extends JpaRepository<ProductFileImage, Long> {

    Optional<ProductFileImage> findByFileName(String fileName);
}
