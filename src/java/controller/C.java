/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class C {
    
    private static final String URL = "jdbc:mysql://localhost/webservice";
    private static final String DRIVE = "com.mysql.jdbc.Drive";
    private static final String USER = "root";
    private static final String PASS = USER;
    
    private static Connection con;
    
    public static Connection cb() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVE);
        con = DriverManager.getConnection(URL,USER,PASS);
        return con;
    }
    
    public static void db() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
