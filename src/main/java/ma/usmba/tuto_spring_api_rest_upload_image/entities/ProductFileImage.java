package ma.usmba.tuto_spring_api_rest_upload_image.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFileImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private String filePath;
}
