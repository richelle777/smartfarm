package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.service.ICategorie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategorieRestController {
    @Autowired
    private ICategorie iCategorie;

    @GetMapping("/all")
    public ResponseEntity<List<CategorieDto>> getAllCategories() {
        return ResponseEntity.ok(iCategorie.listCategories());
    }
}
