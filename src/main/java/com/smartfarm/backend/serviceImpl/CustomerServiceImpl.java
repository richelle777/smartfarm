package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CustomerMapper;
import com.smartfarm.backend.model.dto.ConnexionForm;
import com.smartfarm.backend.model.dto.CustomerDto;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Customer;
import com.smartfarm.backend.model.entities.Fermier;
import com.smartfarm.backend.model.entities.Image;
import com.smartfarm.backend.repository.CustomerRepository;
import com.smartfarm.backend.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CustomerDto> listCustomers() {
        return  customerRepository.findAll().stream().map(customer -> customerMapper.toDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> save(CustomerDto customerDto) {
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 1000);
            id = "CU" + code;
            if (!customerRepository.existsById(id))
                isIdNotNew = false;
        }
        customerDto.setId(id);
        if(customerRepository.findById(customerDto.getId()).isPresent() || customerRepository.findById(customerDto.getEmail()).isPresent()){
            return ResponseEntity.ok("this user is already save");
        }
        else {
             customerRepository.save(customerMapper.toEntity(customerDto)).getId();
            System.out.println(customerDto);
            return ResponseEntity.ok(customerDto);
        }
    }

    @Override
    public ResponseEntity<?> authentification(ConnexionForm connexionForm) {
        if(customerRepository.existsByEmail(connexionForm.getEmail())){
            Customer customer = customerRepository.findByEmail(connexionForm.getEmail()).get();
            System.out.println(customer);
            if (customer.getMotDePasse().equals(connexionForm.getPassword())){
                return  ResponseEntity.ok(customer);
            }else {
                return ResponseEntity.ok("mdp incorrect");
            }
        }
        return  ResponseEntity.ok("email doesn't exist");
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        //recherche l'entitite qui correspond au client que nous rechercons
        //update
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        customerMapper.copy(customerDto,customer);
        return customerMapper.toDto(customerRepository.save(customer));

    }
}
