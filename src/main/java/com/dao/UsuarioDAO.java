package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.configuracion.Conexion;
import com.modelo.Medico;
import com.modelo.Paciente;

import javax.servlet.http.HttpServletRequest;

public class UsuarioDAO {
    //creamos las variables para conectar la base de datos
    Connection con;
    //creamos una instancia con la clase que creamos en el paquete setting
    Conexion conexion = new Conexion();
    //aqui preparamos la declaracion sql
    PreparedStatement preparedStatement;
    //aqui se retornan datos en las consultas sql
    ResultSet rs;

    public Object login(String correo, String contrasena, HttpServletRequest req) {
        try {
            Paciente p = new Paciente();
            String sql = "select * from paciente where Correo = '"+correo+"' and Contraseña = '"+contrasena+"'";
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                p.setIdPaciente(rs.getInt(1));
                p.setNombreCompleto(rs.getString(2));
                p.setTipoDocumento(rs.getString(3));
                p.setNumeroDocumento(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setCorreo(rs.getString(6));
                p.setContrasena(rs.getString(7));
                req.getSession().setAttribute("sesion", p);
                return p;
            } 

            sql = "select * from medico where Correo = '"+correo+"' and Contraseña = '"+contrasena+"'";
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMedico(rs.getInt(1));
                m.setNombreCompleto(rs.getString(2));
                m.setEspecialidad(rs.getString(3));
                m.setSede(rs.getString(4));
                m.setCorreo(rs.getString(5));
                m.setContrasena(rs.getString(6));
                req.getSession().setAttribute("sesion", m);
                return m;
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }
}