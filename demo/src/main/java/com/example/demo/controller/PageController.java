package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Spring_IoC.Printer;
import com.example.demo.Spring_MVC_test.Store;
import com.example.demo.Spring_MVC_test.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PageController {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;

    @RequestMapping("/test")
    public String test() {
        printer.print("Hello World");
        return "Hello Word";
    }
    
    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }
    
    @RequestMapping("/user")
    public Student user() {
        Student student = new Student();
        student.setName("Judy");
        return student;
    }
}
