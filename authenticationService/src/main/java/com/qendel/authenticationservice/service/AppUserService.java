package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.dto.AppUserDto;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.model.Video;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    String forgotPassword(String email);
    String resetPassword(String token, String password);
    List<AppUserDto> findAllUsers();

    Tutor searchTutorNameByUser(String name);

    Optional<AppUserDto> findUserById(Long id);

    Optional<AppUserDto> findUserByName(String name);

    List<AppUserDto> findAllUsersByRole(String role);

    Optional<AppUserDto> findUserByEmail(String email);

    AppUserDto viewProfile(Long id);

    AppUserDto updateProfile(Long id, AppUser appUser);

    List<Video> searchVideosByPrice(int price);

    List<Video> searchVideoByTutorName(String name);

}
