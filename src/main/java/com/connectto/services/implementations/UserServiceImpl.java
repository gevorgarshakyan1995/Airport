package com.connectto.services.implementations;

import com.connectto.DTO.UserDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.Mapper.UserMapper;
import com.connectto.model.User;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserMapper mapper  = Mappers.getMapper(UserMapper.class);

    @Override
    public void save(UserDto userDto) {
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        User user = mapper.ToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDto getBYEmail(String email) throws NotFoundException {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return mapper.ToUserDto(user);
    }
}
