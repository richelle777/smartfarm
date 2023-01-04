package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CustomerMapper;
import com.smartfarm.backend.model.dto.CustomerDto;
import com.smartfarm.backend.repository.CustomerRepository;
import com.smartfarm.backend.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomer {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDto findById(String id) {
        if (customerRepository.existsById(id)){
            return customerMapper.toDto(customerRepository.findById(id).get());
        }
        return null;
    }
}
