package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream()
                .filter(student -> student.getAverageGrade() == averageGrade)
                .findFirst()
                .orElse(null);
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream()
                .max(Comparator.comparing(Student::getAverageGrade))
                .orElse(null);
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream()
                .min(Comparator.comparing(Student::getAverageGrade))
                .orElse(null);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}