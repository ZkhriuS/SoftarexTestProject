package com.softarex.classroom.Classroom.model;

public class Student {
    private String firstName;
    private String lastName;
    private boolean handUp;

   public  Student(){
       firstName = "Name";
       lastName = "Surname";
   }

   public Student(String firstName, String lastName){
       this.firstName = firstName;
       this.lastName = lastName;
   }

    public void setHandUp(boolean handUp) {
        this.handUp = handUp;
    }
}
