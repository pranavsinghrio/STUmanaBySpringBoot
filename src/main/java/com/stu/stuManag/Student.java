package com.stu.stuManag;

public class Student {
    public String name;

    public Student(String name, int id, int age, String course) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.course = course;
    }

    public int id;
    public int age;
    public String course;
}
