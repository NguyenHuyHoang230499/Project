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
public class Parent {
    public int ParentId;
    public String ParentName;
    public boolean ParentSex;
    public String ParentPhone;
    public String ParentAddress;
    public ArrayList<Student> students;

    public Parent() {
    }

    public Parent(int ParentId, String ParentName, boolean ParentSex, String ParentPhone, String ParentAddress, ArrayList<Student> students) {
        this.ParentId = ParentId;
        this.ParentName = ParentName;
        this.ParentSex = ParentSex;
        this.ParentPhone = ParentPhone;
        this.ParentAddress = ParentAddress;
        this.students = students;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int ParentId) {
        this.ParentId = ParentId;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String ParentName) {
        this.ParentName = ParentName;
    }

    public boolean isParentSex() {
        return ParentSex;
    }

    public void setParentSex(boolean ParentSex) {
        this.ParentSex = ParentSex;
    }

    public String getParentPhone() {
        return ParentPhone;
    }

    public void setParentPhone(String ParentPhone) {
        this.ParentPhone = ParentPhone;
    }

    public String getParentAddress() {
        return ParentAddress;
    }

    public void setParentAddress(String ParentAddress) {
        this.ParentAddress = ParentAddress;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
}
