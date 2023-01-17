package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.ImageMapper;
import com.smartfarm.backend.model.dto.ImageDto;
import com.smartfarm.backend.model.entities.Image;
import com.smartfarm.backend.repository.ImageRepository;
import com.smartfarm.backend.service.Iimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageImpl implements Iimage {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ImageMapper imageMapper;

    @Override
    public ImageDto store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(fileName, file.getBytes());

        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 10000);
            id = "IM" + code;
            if (!imageRepository.existsById(id))
                isIdNotNew = false;
        }
        image.setId(id);

        return imageMapper.toDto(imageRepository.save(image));
    }

    @Override
    public ImageDto getImageById(String id) {
        if (imageRepository.existsById(id)){
            return imageMapper.toDto(imageRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public ImageDto update(MultipartFile file, String id) throws IOException {
        Image image = imageRepository.findById(id).get();
        image.setData(file.getBytes());
        image.setName(file.getOriginalFilename());
        return imageMapper.toDto(imageRepository.save(image));
    }
}
