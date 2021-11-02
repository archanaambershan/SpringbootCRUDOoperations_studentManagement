package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
