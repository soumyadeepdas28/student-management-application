package com.example.student.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;

import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepo;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    Student student = new Student();

    @BeforeEach
    public void setUp() 
    {
      
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Doe");
        student.setReg_id("REG123");
        student.setBranch("Computer Science");
        student.setCgpa(7.5);
        student.setBacklog_count(0);
        //studentRepo.save(student);
    
    }

    @Test
    public void testsearchByID()
    {
        int id=1;
        


        when(studentRepo.findById(id)).thenReturn(Optional.ofNullable(student));
       Student fetchedstudent= studentService.searchByID(id);
       assertNotNull(fetchedstudent);
         assertEquals("John", fetchedstudent.getFirst_name());
         assertEquals("Doe", fetchedstudent.getLast_name());
       

}

@Test
public void testaddStudent()
{
    when(studentRepo.save(student)).thenReturn(student);
       Student addstudent= studentService.addStudent(student);
       assertNotNull(addstudent);
       assertEquals("REG123",addstudent.getReg_id());


}

  

   

}


