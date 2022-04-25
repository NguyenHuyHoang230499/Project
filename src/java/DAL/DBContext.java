/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author senan
 */
public class DBContext {
    protected Connection connection;
    public DBContext(){
        try{
            String url ="jdbc:sqlserver://localhost:1433;databaseName=Project";
            String username="hoangnhhe153383";
            String password="8456852";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection(url,username,password);
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.print(ex);
        }
    }
    
}
