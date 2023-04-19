package com.qendel.regisrationservice.repository;

import com.qendel.regisrationservice.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Authentication, Long> {
}
