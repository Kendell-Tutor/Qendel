package com.qendel.authenticationservice.service.impl;


import com.qendel.authenticationservice.dto.AppUserDto;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.registration.token.ConfirmationToken;
import com.qendel.authenticationservice.registration.token.ConfirmationTokenService;
import com.qendel.authenticationservice.repository.AppUserRepository;
import com.qendel.authenticationservice.service.AppUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
public class AppUserServiceImpl implements UserDetailsService ,AppUserService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private ModelMapper modelMapper;
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

            throw new IllegalStateException("email already taken for sure --------");
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

    @Override
    public List<AppUserDto> findAllUsers() {
        var allUsers = appUserRepository.findAll();
        return allUsers.stream()
                .map(m -> modelMapper.map(allUsers, AppUserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<AppUserDto> findUserById(Long id) {
        return appUserRepository.findAll().stream()
                .filter(u -> u.getId() == id)
                .map(m -> modelMapper.map(m,AppUserDto.class))
                .findFirst();
    }
    @Override
    public Optional<AppUserDto> findUserByName(String name) {
        return appUserRepository.findAll().stream()
                .filter(u -> u.getFirstName().contains(name))
                .map(m -> modelMapper.map(m,AppUserDto.class))
                .findFirst();
    }
    @Override
    public List<AppUserDto> findAllUsersByRole(String role) {
        return appUserRepository.findAll().stream()
                .filter(r -> r.getUserRole().toString().equals(role.toUpperCase()))
                .map(m -> modelMapper.map(m,AppUserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<AppUserDto> findUserByEmail(String email) {
        return appUserRepository.findAll().stream()
                .filter(e -> e.getEmail().equals(email))
                .map(m -> modelMapper.map(m,AppUserDto.class))
                .findFirst();
    }

    @Override
    public AppUserDto viewProfile(Long id) {
       var userView = appUserRepository.findById(id).get();
       return modelMapper.map(userView,AppUserDto.class);
    }

    @Override
    public AppUserDto updateProfile(Long id, AppUser updatedUser) {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setUserRole(updatedUser.getUserRole());
            user.setLocked(updatedUser.getLocked());
            user.setEnabled(updatedUser.getEnabled());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setGender(updatedUser.getGender());
            user.setDateOfBirth(updatedUser.getDateOfBirth());

            appUserRepository.save(user);
            return modelMapper.map(user,AppUserDto.class);
        } else {
            return null;
        }
    }
}
