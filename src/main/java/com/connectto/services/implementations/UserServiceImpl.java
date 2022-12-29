package com.connectto.services.implementations;

import com.connectto.DTO.Response.UserDto;
import com.connectto.model.User;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAuthoriti(userDto.getAuthoriti());
        userRepository.save(user);
    }
}
