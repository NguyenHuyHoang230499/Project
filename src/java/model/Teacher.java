/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author senan
 */
public class Teacher {
    public int TeacherId;
    public String TeacherName;
    public boolean TeacherSex;
    public String TeacherPhone;
    public String TeacherAddress;
    public String Subject;
    public ArrayList<Class> teacherClasses;
    public ArrayList<Student> teacherStudents;

    public Teacher() {
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int TeacherId) {
        this.TeacherId = TeacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    public boolean isTeacherSex() {
        return TeacherSex;
    }

    public void setTeacherSex(boolean TeacherSex) {
        this.TeacherSex = TeacherSex;
    }

    public String getTeacherPhone() {
        return TeacherPhone;
    }

    public void setTeacherPhone(String TeacherPhone) {
        this.TeacherPhone = TeacherPhone;
    }

    public String getTeacherAddress() {
        return TeacherAddress;
    }

    public void setTeacherAddress(String TeacherAddress) {
        this.TeacherAddress = TeacherAddress;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public ArrayList<Class> getTeacherClasses() {
        return teacherClasses;
    }

    public void setTeacherClasses(ArrayList<Class> teacherClasses) {
        this.teacherClasses = teacherClasses;
    }

    public ArrayList<Student> getTeacherStudents() {
        return teacherStudents;
    }

    public void setTeacherStudents(ArrayList<Student> teacherStudents) {
        this.teacherStudents = teacherStudents;
    }
    
}
