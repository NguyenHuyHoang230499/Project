/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Parent;
import model.Staff;
import model.Student;
import model.Teacher;

/**
 *
 * @author senan
 */
public class StaffDAO extends DBContext{
    public Staff getStaff(int id){
        String sql ="select * from Staff\n" +
"where StaffId =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffId"));
                s.setStaffName(rs.getString("StaffName"));
                s.setStaffPhone(rs.getString("StaffPhone"));
                s.setStaffPosition(rs.getString("StaffPosition"));
                s.setStaffSex(rs.getBoolean("StaffSex"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Teacher> getAllTeacher(){
        ArrayList<Teacher> teachers =new ArrayList<>();
        String sql ="select * from Teacher";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Teacher t = new Teacher();
                t.setTeacherId(rs.getInt("TeacherId"));
                t.setTeacherName(rs.getString("TeacherName"));
                t.setTeacherSex(rs.getBoolean("TeacherSex"));
                t.setTeacherPhone(rs.getString("TeacherPhone"));
                t.setTeacherAddress(rs.getString("TeacherAddress"));
                t.setSubject(rs.getString("Subject"));
                teachers.add(t);
            }
            return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Parent> getAllParent(){
        ArrayList<Parent> parents = new ArrayList<>();
        String sql ="select * from Parent";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            int pid =-111;
            while(rs.next()){
                if(pid != rs.getInt("ParentId")){
                    pid=rs.getInt("ParentId");
                    Parent p = new Parent();
                    p.setParentId(pid);
                    p.setParentName(rs.getString("ParentName"));
                    p.setParentSex(rs.getBoolean("ParentSex"));
                    p.setParentPhone(rs.getString("ParentPhone"));
                    p.setParentAddress(rs.getString("ParentAddress"));
                    parents.add(p);
                }
            }
            return parents;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        String sql ="select * from Student";
        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Student s= new Student();
                s.setStudentId(rs.getInt("StudentId"));
                s.setStudentName(rs.getString("StudentName"));
                s.setStudentSex(rs.getBoolean("StudentSex"));
                s.setStudentDate(rs.getDate("StudentBirth"));
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;}
}
