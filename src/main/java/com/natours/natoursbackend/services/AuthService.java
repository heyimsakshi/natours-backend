package com.natours.natoursbackend.services;

import com.natours.natoursbackend.exceptions.UserAlreadyPresentException;
import com.natours.natoursbackend.dto.RegisterRequest;
import com.natours.natoursbackend.models.AppUser;
import com.natours.natoursbackend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void register(RegisterRequest registerRequest) throws Exception {

        Optional<AppUser> appUserOptional = userRepository.findByEmail(registerRequest.getEmail());
        if(appUserOptional.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setName(registerRequest.getName());
            appUser.setEmail(registerRequest.getEmail());
            appUser.setPassword(registerRequest.getPassword());
            appUser.setCreatedDate(Instant.now());
            userRepository.save(appUser);
        }else{
            throw new UserAlreadyPresentException("User Is Already Present With The Given Email Address:- " + registerRequest.getEmail());
        }

    }
}
