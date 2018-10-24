package com.llwantedll.service;

import com.llwantedll.dao.UserDAO;
import com.llwantedll.model.entities.Role;
import com.llwantedll.model.logic.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetailsCustom userDetails = new UserDetailsCustom(userDAO.findByLogin(s));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for(Role role : userDetails.getUser().getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return userDetails;
    }


}
