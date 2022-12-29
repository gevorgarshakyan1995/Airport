package com.connectto.services.implementations;

import com.connectto.DTO.Response.UserDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.User;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);
        user.setAuthoriti(userDto.getAuthoriti());
        userRepository.save(user);
    }

    @Override
    public User getBYEmail(String email)throws NotFoundException {
        User user = userRepository.getByEmail(email);

        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }
}
