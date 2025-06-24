package com.example.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;


@DataJpaTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentrepo;

    @Test
    public void saveStudentTest()
    {
        Student student =new Student();
        student.setId(1);
        student.setFirst_name("Soumyadeep");
        student.setLast_name("Das");
        student.setReg_id("MCA001");
        student.setBranch("MCA");
        student.setCgpa(9.0);
        student.setBacklog_count(0);

        Student savedstudent = studentrepo.save(student);

        assertNotNull(savedstudent);
        assertEquals("MCA001",savedstudent.getReg_id());
    
    }

    @Test
    public void getStudentTest()
    {
        Student student =new Student();
        student.setId(1);
        student.setFirst_name("Soumyadeep");
        student.setLast_name("Das");
        student.setReg_id("MCA001");
        student.setBranch("MCA");
        student.setCgpa(9.0);
        student.setBacklog_count(0);

        Student fetchedStudent = studentrepo.findById(student.getId()).orElse(null);

        assertNotNull(fetchedStudent);
        assertEquals(student.getId(),fetchedStudent.getId());


    }
    
    @Test
    public void getAllTest()
    {

        Student student1 =new Student();
        student1.setId(1);
        student1.setFirst_name("Soumyadeep");
        student1.setLast_name("Das");
        student1.setReg_id("MCA001");
        student1.setBranch("MCA");
        student1.setCgpa(9.0);
        student1.setBacklog_count(0);

        Student student2 =new Student();
        student2.setId(1);
        student2.setFirst_name("Sandeep");
        student2.setLast_name("Dey");
        student2.setReg_id("MCA002");
        student2.setBranch("MCA");
        student2.setCgpa(9.0);
        student2.setBacklog_count(0);


        studentrepo.save(student1);
        studentrepo.save(student2);

        List<Student> students =studentrepo.findAll();

        assertNotNull(students);
        assertEquals(2, students.size());

    }

    @Test
    public void updateStudentTest()
    {

        Student student =new Student();
        student.setId(1);
        student.setFirst_name("Soumyadeep");
        student.setLast_name("Das");
        student.setReg_id("MCA001");
        student.setBranch("MCA");
        student.setCgpa(9.0);
        student.setBacklog_count(0);

        Student savedstudent = studentrepo.save(student);

        savedstudent.setFirst_name("John");
        savedstudent.setLast_name("Doe");

        studentrepo.save(savedstudent);

        Student updatedStudent = studentrepo.findById(student.getId()).orElse(null);

        assertNotNull(updatedStudent);
        assertEquals("John",updatedStudent.getFirst_name());
        assertEquals("Doe",updatedStudent.getLast_name());
}

@Test
public void deleteStudentTest()
{
    
}

}
