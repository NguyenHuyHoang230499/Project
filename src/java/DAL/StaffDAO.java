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
    public int UpdateTeacher(Teacher t){
        String sql = "UPDATE [Teacher]\n" +
"   SET [TeacherName] = ?\n" +
"      ,[TeacherSex] = ?\n" +
"      ,[TeacherPhone] = ?\n" +
"      ,[TeacherAddress] = ?\n" +
"      ,[Subject] = ?\n" +
" WHERE TeacherId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, t.getTeacherName());
            statement.setBoolean(2, t.isTeacherSex());
            statement.setString(3, t.getTeacherPhone());
            statement.setString(4, t.getTeacherAddress());
            statement.setString(5, t.getSubject());
            statement.setInt(6, t.getTeacherId());
            int check = statement.executeUpdate();
            return check;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int UpdateParent(Parent p){
        String sql ="UPDATE [Parent]\n" +
"   SET [ParentName] = ?\n" +
"      ,[ParentSex] = ?\n" +
"      ,[ParentPhone] = ?\n" +
"      ,[ParentAddress] = ?\n" +
" WHERE ParentId =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getParentName());
            statement.setBoolean(2, p.isParentSex());
            statement.setString(3, p.getParentPhone());
            statement.setString(4, p.getParentAddress());
            statement.setInt(5, p.getParentId());
            int check =statement.executeUpdate();
            return check;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public Student getStudent(int id){
        String sql ="select * from Student\n" +
"where StudentId = ?";
        try {
            PreparedStatement s = connection.prepareStatement(sql);
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                Student st = new Student();
                st.setStudentId(rs.getInt("StudentId"));
                st.setStudentName(rs.getString("StudentName"));
                st.setStudentSex(rs.getBoolean("StudentSex"));
                st.setStudentDate(rs.getDate("StudentBirth"));
                return st;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int UpdateStudent(Student st){
        String sql ="UPDATE [Student]\n" +
"   SET [StudentName] = ?\n" +
"      ,[StudentSex] = ?\n" +
"      ,[StudentBirth] =?\n" +
" WHERE StudentId =?";
        try {
            PreparedStatement s= connection.prepareStatement(sql);
            s.setString(1, st.getStudentName());
            s.setBoolean(2, st.isStudentSex());
            s.setDate(3, st.getStudentDate());
            s.setInt(4, st.getStudentId());
            int check = s.executeUpdate();
            return check;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
