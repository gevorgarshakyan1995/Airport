package com.connectto.config;


import com.connectto.DTO.UserDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.Authority;
import com.connectto.model.User;
import com.connectto.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto user;
        try{
            user = userService.getBYEmail(s);
        }catch (NotFoundException e){
            throw  new UsernameNotFoundException("Wrong user email: " + s);
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Authority authority : user.getAuthoriti()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}