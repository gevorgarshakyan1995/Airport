package com.connectto.services.interfaces;

import com.connectto.DTO.Request.UserDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.User;

public interface UserService {
    void save(UserDto userDto);

    User getBYEmail(String email)throws NotFoundException;
}
