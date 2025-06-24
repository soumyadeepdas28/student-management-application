package com.example.integration;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl ="http://localhost";

    private static RestTemplate restTemplate;

    private Student student;

    @Autowired
    private StudentRepo studentrepo;

    @BeforeEach
    public void beforeSetup()
    {
        baseUrl = baseUrl + ":" + port + "/api";

        student =new Student();
        student.setId(1);
        student.setFirst_name("Soumyadeep");
        student.setLast_name("Das");
        student.setReg_id("MCA001");
        student.setBranch("MCA");
        student.setCgpa(9.0);
        student.setBacklog_count(0);

        student = studentrepo.save(student);

    }
    

}
