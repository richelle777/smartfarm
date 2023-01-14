package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ImageDto;
import com.smartfarm.backend.service.Iimage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/image")
@Slf4j
public class ImageRestController {
    @Autowired
    Iimage iimage;

    @GetMapping("/{id}/data")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id){
        ImageRestController.log.info("Téléchargement de l'image : " + id);
        ImageDto imageDto = iimage.getImageById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageDto.getName() + "\"")
                .body(imageDto.getData());
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<ImageDto> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        ImageRestController.log.info("Téléversement de l'image...");
        return ResponseEntity.ok(iimage.store(file));
    }
}
