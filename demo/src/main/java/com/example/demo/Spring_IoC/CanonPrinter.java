package com.example.demo.Spring_IoC;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class CanonPrinter implements Printer {

    private int count;

    @PostConstruct
    public void initialize() {
        count = 5;
    }

    @Override
    public void print(String message) {
        count--;
        // TODO Auto-generated method stub
        System.out.println("Canon印表機: " + message);
        System.out.println("剩餘使用次數：" + count);
    }
    
}
