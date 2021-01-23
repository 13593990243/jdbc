package com.day16.job.sever;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private Integer class_id;
    private String name;
    private String sex;
    private Integer age;


    public Student() {
    }

    public Student(Integer id, Integer class_id, String name, String sex, Integer age) {
        this.id = id;
        this.class_id = class_id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
