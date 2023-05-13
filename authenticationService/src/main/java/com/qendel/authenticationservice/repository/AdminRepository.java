package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM admin WHERE email =:userEmail")
    Admin findAdminByEmail(String userEmail);
}
