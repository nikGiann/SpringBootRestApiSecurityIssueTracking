package com.nikgian.service;


import com.nikgian.model.Role;
import com.nikgian.repos.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override 
    public Role findById(Integer id) {
        Optional<Role> result = roleRepository.findById(id);
		
		Role theRole = null;
		
		if (result.isPresent()) {
			theRole = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find Role id - " + id);
		}
		
		return theRole;
    }
    
}
