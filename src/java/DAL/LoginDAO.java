/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Parent;

/**
 *
 * @author senan
 */
public class LoginDAO  extends DBContext{
    public int LoginParent(String id,String pass){
        String sql ="select * from Parent\n" +
"where ParentId = ? and ParentPhone=?";
        try {
            PreparedStatement s = connection.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(id));
            s.setString(2,pass);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                return Integer.parseInt(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int LoginTeacher(String id,String pass){
        String sql ="select * from Teacher\n" +
"where TeacherId = ? and TeacherPhone=?";
        try {
            PreparedStatement s = connection.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(id));
            s.setString(2,pass);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                return Integer.parseInt(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int LoginStaff(String id,String pass){
        String sql ="select * from Staff\n" +
"where StaffId = ? and StaffPhone=?";
        try {
            PreparedStatement s = connection.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(id));
            s.setString(2,pass);
            ResultSet rs = s.executeQuery();
            if(rs.next()){
                return Integer.parseInt(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
