package com.example.ABCBank.Repositories;

import com.example.ABCBank.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String role_employee);
}