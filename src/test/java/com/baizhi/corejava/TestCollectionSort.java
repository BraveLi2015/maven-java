package com.baizhi.corejava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class TestCollectionSort {

    @Test
    public void test1() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhang3",19));
        list.add(new Student("li4",14));
        list.add(new Student("wang5",29));
        list.add(new Student("ma6",15));
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        };
        Collections.sort(list,c);
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
