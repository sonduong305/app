package com.example.sonduong.intentex;

import java.io.Serializable;

public class Student implements Serializable {
    private String num1;
    private String num2;

    public Student(){}

    public String getName() {
        return num1;
    }

    public void setName(String name) {
        this.num1 = name;
    }

    public String getAge() {
        return num2;
    }

    public void setAge(String age) {
        this.num2 = age;
    }
}
