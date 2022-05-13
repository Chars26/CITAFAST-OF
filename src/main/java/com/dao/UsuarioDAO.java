package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.configuracion.Conexion;
import com.modelo.Medico;
import com.modelo.Paciente;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

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

    public boolean registrarMedico(Medico m) {
        try {
                String sql = "insert into medico(Nombre Completo, Especialidad, Sede, Correo, Contraseña) values(?,?,?,?,?)";
                con = conexion.getConexion();
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, m.getNombreCompleto());
                preparedStatement.setString(2, m.getEspecialidad());
                preparedStatement.setString(3, m.getSede());
                preparedStatement.setString(4, m.getCorreo());
                preparedStatement.setString(5, m.getContrasena());
                preparedStatement.executeUpdate();
                return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean registrarPaciente(Paciente p) {
        try {
                String sql = "insert into paciente(Nombre Completo, Tipo Documento, Numero Documento, Telefono, Correo, Contraseña) values(?,?,?,?,?,?)";
                con = conexion.getConexion();
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, p.getNombreCompleto());
                preparedStatement.setString(2, p.getTipoDocumento());
                preparedStatement.setString(3, p.getNumeroDocumento());
                preparedStatement.setString(4, p.getTelefono());
                preparedStatement.setString(5, p.getCorreo());
                preparedStatement.setString(6, p.getContrasena());
                preparedStatement.executeUpdate();
                return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }
}