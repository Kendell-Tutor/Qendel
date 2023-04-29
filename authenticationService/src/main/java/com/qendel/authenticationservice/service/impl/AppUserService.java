package com.qendel.authenticationservice.service.impl;


import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.registration.token.ConfirmationToken;
import com.qendel.authenticationservice.registration.token.ConfirmationTokenService;
import com.qendel.authenticationservice.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    /**
     * for list user retrieval
     */

    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findUserById(Long id) {
        return appUserRepository.findAll().stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public Optional<AppUser> findUserByName(String name) {
        return appUserRepository.findAll().stream()
                .filter(u -> u.getFirstName().contains(name))
                .findFirst();
    }

    public List<AppUser> findAllUsersByRole(String role) {
        return appUserRepository.findAll().stream()
                .filter(r -> r.getUserRole().toString().equals(role.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Optional<AppUser> findUserByEmail(String email) {
        return appUserRepository.findAll().stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
    }
}
