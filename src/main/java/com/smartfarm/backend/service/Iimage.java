package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface Iimage {
    ImageDto store(MultipartFile file) throws IOException;
    ImageDto getImageById(String id);
    ImageDto update(MultipartFile file, String id) throws IOException;
}
