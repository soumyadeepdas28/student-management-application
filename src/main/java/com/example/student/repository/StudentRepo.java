package com.example.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.entity.Student;

import java.util.Optional;



public interface  StudentRepo extends JpaRepository<Student,Integer> {

}
