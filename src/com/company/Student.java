package com.company;

public class Student {
    int[] score = new int[3];
    String name;

    public Student(int[] score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
