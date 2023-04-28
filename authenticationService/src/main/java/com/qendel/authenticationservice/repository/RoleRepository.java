package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Role;
import com.qendel.authenticationservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);

}
