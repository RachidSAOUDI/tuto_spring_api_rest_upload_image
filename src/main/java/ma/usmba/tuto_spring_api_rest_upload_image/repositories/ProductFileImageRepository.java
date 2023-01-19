package ma.usmba.tuto_spring_api_rest_upload_image.repositories;

import ma.usmba.tuto_spring_api_rest_upload_image.entities.ProductFileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFileImageRepository extends JpaRepository<ProductFileImage, Long> {

}
