package com.example.student.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.Entity.Student;



public interface  StudentRepo extends JpaRepository<Student,Integer> {

}