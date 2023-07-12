package com.example.ABCBank.service;

import com.example.ABCBank.Repositories.RoleRepository;
import com.example.ABCBank.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role createRoleByName (String roleName){


//        Role role = new Role(roleName);
//
//        role.setPrivileges(new ArrayList<>());
//        role.setUsers(new ArrayList<>());
//
//        return roleRepository.save(role);

        return new Role();
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role create(String roleName) {
        Role role = new Role(roleName);
        return roleRepository.save(role);
    }
}