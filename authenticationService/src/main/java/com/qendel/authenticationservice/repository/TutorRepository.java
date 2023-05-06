package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    Tutor getTutorByFirstName(String name);
}
