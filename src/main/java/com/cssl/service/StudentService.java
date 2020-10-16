package com.cssl.service;

import com.cssl.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> showAll();

    public Student findById(Integer sid);
    public Student findById2(Integer sid);
}
