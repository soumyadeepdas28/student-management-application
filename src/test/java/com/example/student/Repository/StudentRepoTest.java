package com.example.student.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.student.Entity.Student;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void testSave()
    {

        Student student = new Student();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Doe");
        student.setReg_id("REG123");
        student.setBranch("Computer Science");
        student.setCgpa(7.5);
        student.setBacklog_count(0);

        Student savedStudent = studentRepo.save(student);
        assertNotNull(savedStudent);
        assertEquals(1, savedStudent.getId());
        assertEquals("John", savedStudent.getFirst_name());
        assertEquals("Doe", savedStudent.getLast_name());
        assertEquals("REG123", savedStudent.getReg_id());
        assertEquals("Computer Science", savedStudent.getBranch());
        assertEquals(7.5, savedStudent.getCgpa());
        assertEquals(0, savedStudent.getBacklog_count());
        
    }

    @Test
    public void testUpdate()
    {
        Student student = new Student();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Doe");
        student.setReg_id("REG123");
        student.setBranch("Computer Science");
        student.setCgpa(7.5);
        student.setBacklog_count(0);

        studentRepo.save(student);

        student.setBranch("Information Technology");
        student.setCgpa(8.0);
        student.setBacklog_count(1);

        Student updatedStudent = studentRepo.save(student);
        assertNotNull(updatedStudent);
        assertEquals(1, updatedStudent.getId());
        assertEquals("John", updatedStudent.getFirst_name());
        assertEquals("Doe", updatedStudent.getLast_name());
        assertEquals("REG123", updatedStudent.getReg_id());
        assertEquals("Information Technology", updatedStudent.getBranch());
        assertEquals(8.0, updatedStudent.getCgpa());
        assertEquals(1, updatedStudent.getBacklog_count());
    }

    @Test
    public void testDelete()
    {
        Student student = new Student();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Doe");
        student.setReg_id("REG123");
        student.setBranch("Computer Science");
        student.setCgpa(7.5);
        student.setBacklog_count(0);

        studentRepo.save(student);

        studentRepo.delete(student);
        Optional<Student> deletedStudent = studentRepo.findById(1);

        assertThat(deletedStudent).isEmpty();
        
    }





}
