package com.restaurants.restaurants.services;

import com.restaurants.restaurants.entities.PrivilegeEntity;
import com.restaurants.restaurants.entities.RoleEntity;
import com.restaurants.restaurants.entities.UserEntity;
import com.restaurants.restaurants.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailId(emailId);
        if(user == null) {
            throw new UsernameNotFoundException(emailId);
        }
        return new User(
                user.getEmailId(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(user.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(RoleEntity role) {
        return getGrantedAuthority(getPrivileges(role));
    }

    private List<String> getPrivileges(RoleEntity role) {
        List<String> privileges = new ArrayList<>();
        privileges.add(String.valueOf(role.getRoleName()));
        for(PrivilegeEntity e : role.getPrivileges()) {
            privileges.add(String.valueOf(e.getPrivilegeName()));
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthority(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for( String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
