package com.company;

        import java.util.ArrayList;
        import java.util.Random;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String [] names = {"Александр", "Светлана", "Никита", "Кирилл", "Алексей", "Виктор", "Мария", "Михаил", "Екатерина", "Марина"};
        ArrayList<Student> students = new ArrayList<Student>();
        students = newStudents(names);
        enlisted(students);
        result(students);

    }

    public static int[] scoreIn(){                                  // Задание случайных чисел оценок каждому обьекту
        int[] score = new int[3];
        Random random = new Random();
        for(int i = 0; i<3; i++) {
            score[i] = random.nextInt(10)+1;
        }
        return score;
    }

    public static void enlisted(ArrayList<Student> students) {      // Проверка прохождения учеников
        Scanner passingScore = new Scanner(System.in);
        System.out.println("Введите проходной балл от 1 до 10");
        boolean isInt = passingScore.hasNextInt();
        if (isInt) {
            int score = passingScore.nextInt();
            if(score <= 10 && score >= 0){
                Student newStudent = new Student();
                int totalScore = 0;
                for(int i=0;i<students.size();i++){
                    newStudent = students.get(i);
                    for (int x=0;x<3;x++){
                        totalScore +=newStudent.score[x];
                    }
                    totalScore /=3;
                    if(totalScore >= score){
                        System.out.println(students.get(i).getName() + " зачислен на курс");
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

    public static ArrayList<Student> newStudents(String[] names){  // Создание студентов
        ArrayList<Student> students = new ArrayList<Student>();
        for (int x=0; x<names.length;x++) {
            Student student = new Student(scoreIn(),names[x]);
            students.add(student);
        }
        return students;
    }

    public static void result (ArrayList<Student> students) {       //  Поиск ученика и ывод оценок
        System.out.println("Если вы хотите узнать ваши результаты введите имя");
        Scanner name = new Scanner(System.in);
        String trueName = name.nextLine();
        boolean find = false;
        for(int x=0;x<students.size();x++){
            if(trueName.toLowerCase().equals(students.get(x).name.toLowerCase())){
                System.out.print(students.get(x).getName() + " Оценки по зачислению такие: " );
               score(students.get(x).score);
               find = true;
            }

        }
        if (!find){
            System.out.println("Вы ввели не существующего студента");
        }

    }
    public static void score(int [] score) {                    // Вывод каждой оценки
        for (int i=0;i<score.length;i++) {
            System.out.print(" " + score[i]);
        }
    }
}
