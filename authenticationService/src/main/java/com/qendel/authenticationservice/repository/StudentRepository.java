package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(nativeQuery = true, value = "select * from Student where first_name =:name")
    Optional<Student> findStudentByFirstName(@Param("name") String name);
    @Query(nativeQuery = true, value = "SELECT * FROM student WHERE email =:userEmail")
    Student findAdminByEmail(String userEmail);

}
