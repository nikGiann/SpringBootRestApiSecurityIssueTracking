package com.nikgian.service;

import com.nikgian.model.Role;
import com.nikgian.model.User;

import com.nikgian.repos.UsersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepository usersRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public User findByUserName(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
        User user = usersRepository.findByUsername(string);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
        
        return userDetails;
    }
    
    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        List<GrantedAuthority> authorities = new ArrayList();
        for(Role r:roles){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }
    
}
    

