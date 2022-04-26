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
public class Class {
    public int ClassId;
    public String ClassName;
    public ArrayList<Student> ClassStudents;

    public Class() {
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int ClassId) {
        this.ClassId = ClassId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public ArrayList<Student> getClassStudents() {
        return ClassStudents;
    }

    public void setClassStudents(ArrayList<Student> ClassStudents) {
        this.ClassStudents = ClassStudents;
    }
    
}
