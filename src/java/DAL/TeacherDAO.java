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
import model.Teacher;
import model.Class;
import model.Parent;
import model.Student;
import model.StudentMark;

/**
 *
 * @author senan
 */
public class TeacherDAO extends DBContext {

    public StudentMark getStudentMark(int id, String sub) {
        String sql = "select * from StudentMark s\n"
                + "where s.StudentId=? and s.Subject = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, sub);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                StudentMark sm = new StudentMark();
                sm.setStudentId(rs.getInt("StudentId"));
                sm.setSubject(rs.getString("Subject"));
                sm.setSmalTest(rs.getInt("SmalTest"));
                sm.setMidTest(rs.getInt("MidTest"));
                sm.setFinalTest(rs.getInt("FinalTest"));
                return sm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> getStudentsByClass(int id) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from Student s\n"
                + "inner join ClassStudent cs\n"
                + "on s.StudentId = cs.StudentId\n"
                + "inner join Parent p\n"
                + "on p.StudentId=s.StudentId\n"
                + "where cs.ClassId = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("StudentId"));
                s.setStudentName(rs.getString("StudentName"));
                s.setStudentSex(rs.getBoolean("StudentSex"));
                Parent p = new Parent();
                p.setParentId(rs.getInt("ParentId"));
                p.setParentName(rs.getString("ParentName"));
                p.setParentSex(rs.getBoolean("ParentSex"));
                p.setParentPhone(rs.getString("ParentPhone"));
                p.setParentAddress(rs.getString("ParentAddress"));
                s.setStudentParent(p);
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Teacher getTeacher(int id) {
        String sql = "use Project\n"
                + "select * from Teacher t\n"
                + "inner join ClassTeacher ct\n"
                + "on t.TeacherId =ct.TeacherId\n"
                + "inner join Class c\n"
                + "on c.ClassId = ct.ClassId\n"
                + "where t.TeacherId = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Teacher t = new Teacher();
            int tid = -111;
            ArrayList<Class> classes = new ArrayList<>();
            while (rs.next()) {
                if (tid != rs.getInt("TeacherId")) {
                    tid = rs.getInt("TeacherId");
                    t.setTeacherId(rs.getInt("TeacherId"));
                    t.setTeacherName(rs.getString("TeacherName"));
                    t.setTeacherSex(rs.getBoolean("TeacherSex"));
                    t.setTeacherPhone(rs.getString("TeacherPhone"));
                    t.setTeacherAddress(rs.getString("TeacherAddress"));
                    t.setSubject(rs.getString("Subject"));
                }
                Class c = new Class();
                c.setClassId(rs.getInt("ClassId"));
                c.setClassName(rs.getString("ClassName"));
                classes.add(c);
            }
            t.setTeacherClasses(classes);
            return t;

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int UpdateStudentMark(int sid,int SmalTest,int Midtest,int FinalTest,String subject){
        if(SmalTest <0||SmalTest >10||Midtest <0|| Midtest>10||FinalTest<0||FinalTest>10){
            return 0;
        }
        String sql ="UPDATE [StudentMark]\n" +
"   SET \n" +
"      [SmalTest] = ?\n" +
"      ,[MidTest] = ?\n" +
"      ,[FinalTest] = ?\n" +
" WHERE StudentId = ? and Subject =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, SmalTest);
            statement.setInt(2, Midtest);
            statement.setInt(3, FinalTest);
            statement.setInt(4, sid);
            statement.setString(5, subject);
            int check = statement.executeUpdate();
            return check;
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


}
