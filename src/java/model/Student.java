/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author senan
 */
public class Student {
    public int StudentId;
    public String StudentName;
    public boolean StudentSex;
    public Date StudentDate;
    public ArrayList<StudentMark> studentMarks;
    public Class StudentClass;
    public Parent StudentParent;
    public StudentMark studentMark;

    public StudentMark getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(StudentMark studentMark) {
        this.studentMark = studentMark;
    }
    

    public Parent getStudentParent() {
        return StudentParent;
    }

    public void setStudentParent(Parent StudentParent) {
        this.StudentParent = StudentParent;
    }
    

    public Class getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(Class StudentClass) {
        this.StudentClass = StudentClass;
    }
    

    public Student(int StudentId, String StudentName, boolean StudentSex, Date StudentDate, ArrayList<StudentMark> studentMarks) {
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.StudentSex = StudentSex;
        this.StudentDate = StudentDate;
        this.studentMarks = studentMarks;
    }

    public ArrayList<StudentMark> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(ArrayList<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }
    

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
