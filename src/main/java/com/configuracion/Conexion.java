/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.configuracion;

/**
 *
 * @author santi
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    Connection con;
    String url = "jdbc:mysql://localhost:3306/citifast";
    String user = "root";
    String pass = "Monalisa1503";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
}
