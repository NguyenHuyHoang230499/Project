/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author senan
 */
public class StudentMark {
    public int StudentId;
    public String Subject;
    public int SmalTest;
    public int MidTest;
    public int FinalTest;

    public StudentMark() {
    }

    public StudentMark(int StudentId, String Subject, int SmalTest, int MidTest, int FinalTest) {
        this.StudentId = StudentId;
        this.Subject = Subject;
        this.SmalTest = SmalTest;
        this.MidTest = MidTest;
        this.FinalTest = FinalTest;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public int getSmalTest() {
        return SmalTest;
    }

    public void setSmalTest(int SmalTest) {
        this.SmalTest = SmalTest;
    }

    public int getMidTest() {
        return MidTest;
    }

    public void setMidTest(int MidTest) {
        this.MidTest = MidTest;
    }

    public int getFinalTest() {
        return FinalTest;
    }

    public void setFinalTest(int FinalTest) {
        this.FinalTest = FinalTest;
    }
    
}
