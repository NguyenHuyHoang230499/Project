/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Parent;

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
        } catch (SQLException ex) {
            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
