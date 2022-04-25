/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author senan
 */
public class Student {
    public int StudentId;
    public String StudentName;
    public boolean StudentSex;
    public Date StudentDate;

    public Student() {
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public boolean isStudentSex() {
        return StudentSex;
    }

    public void setStudentSex(boolean StudentSex) {
        this.StudentSex = StudentSex;
    }

    public Date getStudentDate() {
        return StudentDate;
    }

    public void setStudentDate(Date StudentDate) {
        this.StudentDate = StudentDate;
    }
    
}
