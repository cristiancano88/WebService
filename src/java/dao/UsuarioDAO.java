/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.C;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Cristian
 */
public class UsuarioDAO {
    
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
    public List<Usuario> getUsuarios() throws ClassNotFoundException, SQLException {
        
        List<Usuario> usuarios = new ArrayList<>();
        Usuario u = null;
        sql = "SELECT * FROM usuario;";
        con = C.cb();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setPassword(rs.getString("password"));
            
            usuarios.add(u);
        }
        
        C.db();
        return usuarios;
    }
    
}
