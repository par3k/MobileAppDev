package com.example.login;

import android.content.Context;
import android.widget.TextView;

public class Schedule {

    private String monday[]=new String[14];
    private String tuesday[]=new String[14];
    private String wednesday[]=new String[14];
    private String thursday[]=new String[14];
    private String friday[]=new String[14];

    public Schedule(){
        for(int i=0;i<14;i++){
            monday[i]="";
            tuesday[i]="";
            wednesday[i]="";
            thursday[i]="";
            friday[i]="";
        }
    }
    public void addSchedule(String scheduleText){
        int temp;
        //Mon:[2][3][4]
        if((temp=scheduleText.indexOf("Mon")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]="수";
                }
            }
        }

        if((temp=scheduleText.indexOf("Tue")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i)!=':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]="수업";
                }
            }
        }

        if((temp=scheduleText.indexOf("Wed")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i)!=':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]="수업";
                }
            }
        }
        if((temp=scheduleText.indexOf("Thu")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length()&&scheduleText.charAt(i)!=':';i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]="수업";
                }
            }
        }
        if((temp=scheduleText.indexOf("Fri")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length()&&scheduleText.charAt(i)!=':';i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]="수업";
                }
            }
        }
    }



    public boolean validate(String scheduleText) {
        if (scheduleText.equals("")) {
            return true;
        }
        int temp;
        if ((temp = scheduleText.indexOf("Mon")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("Tue")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("Wed")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        if ((temp = scheduleText.indexOf("Thu")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        if ((temp = scheduleText.indexOf("Fri")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void addSchedule(String scheduleText, String courseTitle, String courseProfessor){
        String professor;
        if(courseProfessor.equals("")){
            professor = "";
        } else {
            professor = "(" + courseProfessor + ")";
        }
        int temp;
        //Mon:[2][3][4]
        if((temp=scheduleText.indexOf("Mon")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]= courseTitle + professor;
                }
            }
        }

        if((temp=scheduleText.indexOf("Tue")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i)!=':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]= courseTitle + professor;
                }
            }
        }

        if((temp=scheduleText.indexOf("Wed")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i)!=':'; i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]= courseTitle + professor;
                }
            }
        }
        if((temp=scheduleText.indexOf("Thu")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length()&&scheduleText.charAt(i)!=':';i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]= courseTitle + professor;
                }
            }
        }
        if((temp=scheduleText.indexOf("Fri")) > -1){
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length()&&scheduleText.charAt(i)!=':';i++){
                if(scheduleText.charAt(i)=='['){
                    startPoint=i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint=i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint+1,endPoint))]= courseTitle + professor;
                }
            }
        }
    }


    public void setting (TextView[] monday, TextView[] tuesday, TextView[] wednesday, TextView[] thursday, TextView[] friday, Context context){
        for(int i=0; i<14; i++){

            if(!this.monday[i].equals("")){
                monday[i].setText(this.monday[i]);
                monday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(!this.tuesday[i].equals("")){
                tuesday[i].setText(this.tuesday[i]);
                tuesday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(!this.wednesday[i].equals("")){
                wednesday[i].setText(this.wednesday[i]);
                wednesday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(!this.thursday[i].equals("")){
                thursday[i].setText(this.thursday[i]);
                thursday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(!this.friday[i].equals("")){
                friday[i].setText(this.friday[i]);
                friday[i].setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }
        }
    }

}
