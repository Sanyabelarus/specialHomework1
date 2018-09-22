package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student sanya = new Student(scoreIn(),"Sanya");
        Student sveta = new Student(scoreIn(),"Sveta");
        Student nikita = new Student(scoreIn(),"Nikita");
        Student kirill = new Student(scoreIn(),"Kirill");
        Student aleksey = new Student(scoreIn(),"Aleksey");
        Student viktor = new Student(scoreIn(), "Viktor");
        Student maria = new Student(scoreIn(), "Maria");
        Student mihail = new Student(scoreIn(), "Mihail");
        Student katya = new Student(scoreIn(), "Katya");
        Student marina = new Student(scoreIn(), "Marina");
        Student [] allStudents = {sanya,sveta,nikita,kirill,aleksey,viktor,maria,mihail,katya,marina};
        enlisted(allStudents);


    }

    public static int[] scoreIn(){
        int[] score = new int[3];
        Random random = new Random();
        for(int i = 0; i<3; i++) {
            score[i] = random.nextInt(10)+1;
        }
        return score;
    }

    public static void enlisted(Student[] students) {
        Scanner passingScore = new Scanner(System.in);
        System.out.println("Введите проходной балл");
        boolean isInt = passingScore.hasNextInt();
        if (isInt) {
            int score = passingScore.nextInt();
            if(score <= 10 && score >= 0){
                Student newStudent = new Student(scoreIn(),null);
                int totalScore = 0;
                for(int i=0;i<students.length;i++){
                   newStudent = students[i];
                   for (int x=0;x<3;x++){
                       totalScore +=newStudent.score[x];
                   }
                   totalScore /=3;
                    if(totalScore >= score){
                        System.out.println(students[i].getName() + " Зачислен на курс");
                    }
                    totalScore = 0;
                }
            }else{
                System.out.println("Введите число от 1 до 10");
            }
        }else{
            System.out.println("Введите правильное число");
        }
    }
}