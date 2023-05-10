package com.connectto.Mapper;

import com.connectto.DTO.UserDto;
import com.connectto.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto ToUserDto(User user);

    User ToUser(UserDto userDto);
}