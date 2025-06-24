package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

   @Mock
   StudentRepo studentrepo;

   @InjectMocks
    StudentService studentservice;

    private static Student student;

    @BeforeEach
    public void init()
    {
        student =new Student();
        student.setId(1);
        student.setFirst_name("Soumyadeep");
        student.setLast_name("Das");
        student.setReg_id("MCA001");
        student.setBranch("MCA");
        student.setCgpa(9.0);
        student.setBacklog_count(0);
    }

    @Test
    void addStudentTest()
    {
       when(studentrepo.save(student)).thenReturn(student);
       Student addstudent= studentservice.addStudent(student);
       assertNotNull(addstudent);
       assertEquals("MCA001",addstudent.getReg_id());


    }

     @AfterAll
    public static void Destroy(){
        System.out.println("destroyed");
    }
    @AfterEach
    public void cleanup(){
        System.out.println("cleaned");
    }

}

