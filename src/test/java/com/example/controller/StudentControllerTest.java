package com.example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.student.controller.StudentController;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static net.bytebuddy.matcher.ElementMatchers.is;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private StudentService studentservice;

    @Autowired
	private ObjectMapper objectMapper;

    private Student student;

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
    public void ShouldaddStudent()throws Exception
    {
        when(studentservice.addStudent(any(Student.class))).thenReturn(student);

        this.mockmvc.perform(post("/api")
         .contentType(MediaType.APPLICATION_JSON)
         .content(objectMapper.writeValueAsString(student)))
         .andExpect(status().isCreated())
         .andExpect((ResultMatcher) jsonPath("$.first_name",is(student.getFirst_name())))
         .andExpect((ResultMatcher) jsonPath("$.last_name",is(student.getLast_name())))
         .andExpect((ResultMatcher) jsonPath("$.reg_id",is(student.getReg_id())));
         
            

        

    }



}
