package com.example.bestpratices.services.domain;

import com.example.bestpratices.model.domain.User;
import com.example.bestpratices.resources.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createUser(UserDTO userDTO) {
        return new User();
    }

    public User findById(Long id) {
        return new User();
    }
}
