package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.configuracion.Conexion;
import com.modelo.Paciente;

public class PacienteDAO {
    //creamos las variables para conectar la base de datos
    Connection con;
    //creamos una instancia con la clase que creamos en el paquete setting
    Conexion conexion = new Conexion();
    //aqui preparamos la declaracion sql
    PreparedStatement preparedStatement;
    //aqui se retornan datos en las consultas sql
    ResultSet rs;

    public Paciente getPaciente(int id) {
        Paciente p = new Paciente();
        try {
            String sql = "select * from paciente where idPaciente = "+id;
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                p.setIdPaciente(id);
                p.setNombreCompleto(rs.getString(2));
                p.setTipoDocumento(rs.getString(3));
                p.setNumeroDocumento(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setCorreo(rs.getString(6));
                p.setContrasena(rs.getString(7));
                return p;
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