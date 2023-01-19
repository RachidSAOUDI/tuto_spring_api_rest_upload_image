package ma.usmba.tuto_spring_api_rest_upload_image.controllers;

import ma.usmba.tuto_spring_api_rest_upload_image.services.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ProductRestController {
    private StorageService storageService;

    public ProductRestController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws Exception{
        String uploadImage = storageService.uploadDataImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
}
