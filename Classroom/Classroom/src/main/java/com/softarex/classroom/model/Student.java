package com.softarex.classroom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "first_name")
    private String firstName;
    @Id
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "hand_up")
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
