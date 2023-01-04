package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.CustomerDto;

public interface ICustomer {
    CustomerDto findById(String id);
}
