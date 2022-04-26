/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Parent;
import model.Student;
import model.Teacher;

/**
 *
 * @author senan
 */
public class ParentDAO extends DBContext{
    public Parent getParent(int id){
        String sql = "select * from Parent p\n" +
"inner join Student s\n" +
"on p.StudentId = s.StudentId\n" +
"where p.ParentId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int pid=-1 ;
            ArrayList<Student> students = new ArrayList<>();
            Parent p = new Parent();
            while(rs.next()){
                if(rs.getInt("ParentId") != pid){
                    pid = rs.getInt("ParentId");
                    p.setParentId(pid);
                    p.setParentName(rs.getString("ParentName"));
                    p.setParentSex(rs.getBoolean("ParentSex"));
                    p.setParentPhone(rs.getString("ParentPhone"));
                    p.setParentAddress(rs.getString("ParentAddress"));
                }
                Student s = new Student();
                s.setStudentDate(Date.valueOf(rs.getString("StudentBirth")));
                s.setStudentId(rs.getInt("StudentId"));
                s.setStudentName(rs.getString("StudentName"));
                s.setStudentSex(rs.getBoolean("StudentSex"));
                students.add(s);
            }
            p.setStudents(students);
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Teacher getTeacherBySubject(String subject,int cid){
        String sql ="select * from Teacher t\n" +
"inner join ClassTeacher ct \n" +
"on t.TeacherId = ct.TeacherId\n" +
"where ct.ClassId = ? and t.Subject =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cid);
            statement.setString(2, subject);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Teacher t = new Teacher();
                t.setTeacherId(rs.getInt("TeacherId"));
                t.setTeacherName(rs.getString("TeacherName"));
                t.setTeacherSex(rs.getBoolean("TeacherSex"));
                t.setTeacherPhone(rs.getString("TeacherPhone"));
                t.setTeacherAddress(rs.getString("TeacherAddress"));
                t.setSubject(rs.getString("Subject"));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
