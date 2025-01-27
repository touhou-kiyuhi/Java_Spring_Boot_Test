package com.example.demo.Spring_IoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    
    @Autowired
    @Qualifier("canonPrinter")
    private Printer printer;

    public void teach() {
        printer.print("I'm a teacher");
    }
}
