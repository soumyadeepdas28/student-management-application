package com.example.student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepo;

@Service
public class StudentService {

     @Autowired
    public StudentRepo studentrepo;

    public Student addStudent(Student student)
    {
        return studentrepo.save(student);
    }

    public Student searchByID(int id)
    {
        Optional<Student> student = studentrepo.findById(id);
        if(student.isEmpty())
        {
            throw new RuntimeException("Student details not found");
            
        }

        return student.get();

    }

    public List<Student> findAll()
        {
            return studentrepo.findAll();

        }
    

    public Student updateStudent(Student student)
    {
        Optional<Student> dbstudent = studentrepo.findById(student.getId());

        if(dbstudent.isEmpty())
        {
            throw new RuntimeException("Student details not found");
        } 
        Student S = dbstudent.get();
        S.setBranch(student.getBranch());
        S.setCgpa(student.getCgpa());
        S.setBacklog_count(student.getBacklog_count());

        return studentrepo.save(student);

            
        

    }

    public void deleteStudent(int id)
    {
        Optional<Student> student = studentrepo.findById(id);
        if(student.isEmpty())
        {
            throw new RuntimeException("Student details not found");
            
        }
        studentrepo.delete(student.get());

    }

}
