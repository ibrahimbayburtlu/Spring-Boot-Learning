package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// It is a class-level annotation. The repository is a DAOs (Data Access Object) that access the database directly.
// The repository does all the operations related to the database.
@Repository
public interface StudentRepository
        extends JpaRepository <Student,Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
