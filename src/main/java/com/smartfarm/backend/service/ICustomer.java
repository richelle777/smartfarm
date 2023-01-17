package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ConnexionForm;
import com.smartfarm.backend.model.dto.CustomerDto;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomer {
    CustomerDto findById(String id);
    ResponseEntity<?> save(CustomerDto customerDto);
    ResponseEntity<?> authentification(ConnexionForm connexionForm);
    List<CustomerDto> listCustomers();
}
