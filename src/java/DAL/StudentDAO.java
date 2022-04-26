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
import model.Student;
import model.StudentMark;
import model.Class;

/**
 *
 * @author senan
 */
public class StudentDAO extends DBContext{
    public Student getStudent(int id){
        String sql = "select * from Student s\n" +
"inner join ClassStudent cs\n" +
"on s.StudentId = cs.StudentId\n" +
"inner join class c \n" +
"on cs.ClassId = c.ClassId\n" +
"inner join StudentMark sm\n" +
"on s.StudentId= sm.StudentId\n" +
"where s.StudentId=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Student s = new Student();
            ArrayList<StudentMark> studentMarks = new ArrayList<>();
            int sid = -10;
            while(rs.next()){
                if(sid != rs.getInt("StudentId")){
                    sid =rs.getInt("StudentId");
                    s.setStudentId(sid);
                    s.setStudentName(rs.getString("StudentName"));
                    s.setStudentDate(rs.getDate("StudentBirth"));
                    s.setStudentSex(rs.getBoolean("StudentSex"));
                    Class c = new Class();
                    c.setClassId(rs.getInt("ClassId"));
                    c.setClassName(rs.getString("ClassName"));
                    s.setStudentClass(c);
                }
                StudentMark sm = new StudentMark();
                sm.setSubject(rs.getString("Subject"));
                sm.setSmalTest(rs.getInt("SmalTest"));
                sm.setMidTest(rs.getInt("MidTest"));
                sm.setFinalTest(rs.getInt("FinalTest"));
                studentMarks.add(sm);
            }
            s.setStudentMarks(studentMarks);
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
