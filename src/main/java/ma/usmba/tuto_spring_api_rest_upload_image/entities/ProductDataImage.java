package ma.usmba.tuto_spring_api_rest_upload_image.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.LobTypeMappings;

@Entity
@Table(name = "PRODUCT_IMAGE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDataImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String imageType;
    @Lob
    @Column(name = "imagedata", length = 100000)
    private byte[] imageData;
}
