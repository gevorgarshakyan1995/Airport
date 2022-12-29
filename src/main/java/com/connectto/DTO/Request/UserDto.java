package com.connectto.DTO.Request;

import com.connectto.model.Authority;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String email;

    private String password;

    private List<Authority> authoriti;
}
