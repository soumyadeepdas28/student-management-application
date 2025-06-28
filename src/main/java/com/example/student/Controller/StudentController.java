package com.example.student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Entity.Student;
import com.example.student.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    
    @Autowired
    private StudentService studentservice;

    @PostMapping("/save")
    public Student save(@RequestBody Student s)
    {
        return studentservice.addStudent(s);
    }

    @GetMapping("/findAll")
    public List<Student> findAll()
    {
        return studentservice.findAll();
    }

    @GetMapping("/searchByID")
    public Student searchByID(@RequestParam int id)
    {
        return studentservice.searchByID(id);
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student S)
    {
        return studentservice.updateStudent(S);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestParam int id)
    {
        studentservice.deleteStudent(id);
    }
}
