package com.cssl.controller;

import com.cssl.entity.Student;
import com.cssl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/getAll")
    public List<Student> getAll(){

      return     studentService.showAll();

    }


    @RequestMapping("/getOne")
    public Student getOne(){

        return     studentService.findById(1);

    }

    @RequestMapping("/getOne2")
    public Student getOne2(Integer id){
        System.out.println("Controller中getOne2:"+id);
        return     studentService.findById2(id);

    }

}
