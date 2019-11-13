package com.example.login;

public class Class {
    private String classname;
    private int photo;

    public Class(){

    }

    public Class(String classname, int photo){
        this.classname = classname;
        this.photo = photo;
    }

    public String getClassname(){
        return classname;
    }

    public void setClassname(String classname){
        this.classname = classname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}


