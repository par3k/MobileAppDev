package com.example.login;

public class Course { // 코스 데이터를 불러올 수 있게 하는 것
    int courseID;//학번
    String courseUniversity;//학부 혹은 대학원
    String courseArea;//강의 영역
    String courseTitle;//강의 제목
    int courseCredit;//강의 학점
    String courseProfessor;//강의 교수
    String courseTime;//강의 기간
    int coursePersonnel; // 강의 제한 인원
    int courseRival; //강의 경쟁자 수

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseUniversity() {
        return courseUniversity;
    }
    public void setCourseUniversity(String courseUniversity) { this.courseUniversity = courseUniversity; }

    public String getCourseArea() {
        return courseArea;
    }
    public void setCourseArea(String courseArea) {
        this.courseArea = courseArea;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCredit() {
        return courseCredit;
    }
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }
    public void setCourseProfessor(String courseProfessor) { this.courseProfessor = courseProfessor; }

    public String getCourseTime() {
        return courseTime;
    }
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Course(int courseID, String courseTitle, int courseCredit, int coursePersonnel, int courseRival) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.coursePersonnel = coursePersonnel;
        this.courseRival = courseRival;
    }

    public Course(int courseID, String courseTitle, int courseCredit, String courseProfessor, String courseTime, int coursePersonnel) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseProfessor = courseProfessor;
        this.courseTime = courseTime;
        this.coursePersonnel = coursePersonnel;
    }

    public int getCoursePersonnel() { return coursePersonnel; }
    public void setCoursePersonnel(int coursePersonnel) { this.coursePersonnel = coursePersonnel; }

    public int getCourseRival() { return courseRival; }
    public void setCourseRival(int courseRival) { this.courseRival = courseRival; }

    public Course(int courseID, String courseUniversity, String courseArea, String courseTitle, int courseCredit, String courseProfessor, String courseTime) {
        this.courseID = courseID;
        this.courseUniversity = courseUniversity;
        this.courseArea = courseArea;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseProfessor = courseProfessor;
        this.courseTime = courseTime;
    }
}
