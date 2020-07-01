package com.nikgian.configuration;

import com.nikgian.model.Role;
import com.nikgian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component //Είναι ένα απλό bean
public class StringToRoleConverter implements Converter<Object, Role>{

    @Autowired
    RoleService roleService;
    
    @Override  // Γτ εμφανίζει το role σαν string και οχι role
    public Role convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Role role = roleService.findById(id);
        return role;
    }

    
    
    
}
