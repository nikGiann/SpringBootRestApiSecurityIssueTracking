package com.nikgian.service;

import com.nikgian.model.Role;
import java.util.List;

public interface RoleService {

    public List<Role> getRoles();

    public Role findById(Integer id);
    
}
