package org.example.spring_globalexpection.Daolayer;

import org.example.spring_globalexpection.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStudentDao extends JpaRepository<Student, Integer>{
    public Optional<Student> findByEmail(String email);
}
