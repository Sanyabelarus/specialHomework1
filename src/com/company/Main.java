package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student sanya = new Student(scoreIn(),"Александр");
        Student sveta = new Student(scoreIn(),"Светлана");
        Student nikita = new Student(scoreIn(),"Никита");
        Student kirill = new Student(scoreIn(),"Кирилл");
        Student aleksey = new Student(scoreIn(),"Алексей");
        Student viktor = new Student(scoreIn(), "Виктор");
        Student maria = new Student(scoreIn(), "Мария");
        Student mihail = new Student(scoreIn(), "Михаил");
        Student katya = new Student(scoreIn(), "Екатерина");
        Student marina = new Student(scoreIn(), "Марина");
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
        System.out.println("Введите проходной балл от 1 до 10");
        boolean isInt = passingScore.hasNextInt();
        if (isInt) {
            int score = passingScore.nextInt();
            if(score <= 10 && score >= 0){
                Student newStudent = new Student();
                int totalScore = 0;
                for(int i=0;i<students.length;i++){
                   newStudent = students[i];
                   for (int x=0;x<3;x++){
                       totalScore +=newStudent.score[x];
                   }
                   totalScore /=3;
                    if(totalScore >= score){
                        System.out.println(students[i].getName() + " зачислен на курс");
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
