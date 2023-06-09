package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    Tutor getTutorByFirstName(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM tutors WHERE email =:userEmail")
    Tutor findAdminByEmail(String userEmail);

}
