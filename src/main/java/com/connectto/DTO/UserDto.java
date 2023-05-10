package com.connectto.DTO;

import com.connectto.model.Authority;

import java.util.List;

public class UserDto {

    private String email;

    private String password;

    private List<Authority> authoriti;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthoriti() {
        return authoriti;
    }

    public void setAuthoriti(List<Authority> authoriti) {
        this.authoriti = authoriti;
    }
}
