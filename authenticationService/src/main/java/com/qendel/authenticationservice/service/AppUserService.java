package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> findAllUsers();
    Optional<AppUser> findUserById(Long id);
    Optional<AppUser> findUserByName(String name);
    List<AppUser> findAllUsersByRole(String role);
    Optional<AppUser> findUserByEmail(String email);
}
