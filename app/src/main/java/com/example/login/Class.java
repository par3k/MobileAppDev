package com.example.login;

public class Class {
    private String classname;
    private String teacher;

    public Class(){

    }

    public Class(String classname, String teacher){
        this.classname = classname;
        this.teacher = teacher;
    }

    public String getClassname(){
        return classname;
    }

    public void setClassname(String classname){
        this.classname = classname;
    }

    public String getTeacher(){
        return teacher;
    }

    public void getTeacher(String teacher){
        this.teacher = teacher;
    }
}


