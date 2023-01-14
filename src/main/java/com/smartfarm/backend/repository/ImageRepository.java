package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,String> {
}
