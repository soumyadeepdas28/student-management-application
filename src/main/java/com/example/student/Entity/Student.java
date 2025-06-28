package com.example.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="students")
@Getter
@Setter
public class Student {

    @Id
    private int id;

    private String first_name;
    private String last_name;
    private String reg_id;
    private String branch;

    private double cgpa;

    private int backlog_count;

    public Student orElse(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElse'");
    }

}
