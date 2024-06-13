package org.example.spring_globalexpection.Model;

public class StudentExpection extends RuntimeException{
    public StudentExpection(String message) {
        super(message);
    }
}
