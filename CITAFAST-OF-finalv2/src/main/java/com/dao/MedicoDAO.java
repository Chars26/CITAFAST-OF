package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.configuracion.Conexion;
import com.modelo.Medico;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    //creamos las variables para conectar la base de datos
    Connection con;
    //creamos una instancia con la clase que creamos en el paquete setting
    Conexion conexion = new Conexion();
    //aqui preparamos la declaracion sql
    PreparedStatement preparedStatement;
    //aqui se retornan datos en las consultas sql
    ResultSet rs;

    public Medico getMedico(int id) {
        Medico m = new Medico();
        try {
            String sql = "select * from medico where idMedico = "+id;
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                m.setIdMedico(id);
                m.setNombreCompleto(rs.getString(2));
                m.setEspecialidad(rs.getString(3));
                m.setSede(rs.getString(4));
                m.setCorreo(rs.getString(5));
                m.setContrasena(rs.getString(6));
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
    
     public List<Medico> getMedicos() {
        List<Medico> medicos = new ArrayList<>();
        try {
            String sql = "select * from medico";
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Medico n = new Medico();
                n.setIdMedico(rs.getInt(1));
                n.setNombreCompleto(rs.getString(2));
                n.setEspecialidad(rs.getString(3));
                n.setSede(rs.getString(4));
                n.setCorreo(rs.getString(5));
                n.setContrasena(rs.getString(6));
                medicos.add(n);
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

        return medicos;
    }
}