package ma.usmba.tuto_spring_api_rest_upload_image.controllers;

import ma.usmba.tuto_spring_api_rest_upload_image.services.StorageFileService;
import ma.usmba.tuto_spring_api_rest_upload_image.services.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ProductRestController {
    private StorageService storageService;
    private StorageFileService storageFileService;

    public ProductRestController(StorageService storageService, StorageFileService storageFileService) {
        this.storageService = storageService;
        this.storageFileService = storageFileService;
    }

    @PostMapping("/data")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws Exception{
        String uploadImage = storageService.uploadDataImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/data/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData = storageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
    @PostMapping("/file")
    public ResponseEntity<?> uploadImageFileToFolder(@RequestParam("image") MultipartFile fileName) throws Exception{
        String uploadImage = storageFileService.uploadImageFileToFolder(fileName);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<?> downloadFromFolder(@PathVariable String fileName) throws Exception {
        byte[] imageData = storageFileService.downloadImageFileFromFolder(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
