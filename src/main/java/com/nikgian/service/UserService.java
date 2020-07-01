package com.nikgian.service;

import com.nikgian.model.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String username);

    public void save(User user);

    public List<User> findAllUsers();

}
