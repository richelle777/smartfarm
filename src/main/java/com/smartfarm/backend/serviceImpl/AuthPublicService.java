package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.model.entities.Customer;
import com.smartfarm.backend.repository.AuthPublicRepository;
import com.smartfarm.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class AuthPublicService {
    @Autowired
    private AuthPublicRepository authPublicRepository;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Customer findCustomerByEmail(String email){
        return authPublicRepository.findByEmail(email);
    }

    public Customer findCustomerByUsername(String username){
        return authPublicRepository.findByUsername(username);
    }

//    public  Customer saveCustomer( Customer customer) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(1);
//
//        final Role userRole = roleRepository.findByRole("ADMIN");
//
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//
//        return userRepository.save(user);
//    }
}
