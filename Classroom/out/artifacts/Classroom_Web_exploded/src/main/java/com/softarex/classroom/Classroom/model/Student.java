package com.softarex.classroom.Classroom.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private boolean handUp;

   public Student(){
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isHandUp() {
        return handUp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", handUp=").append(handUp);
        sb.append('}');
        return sb.toString();
    }
}
