package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.configuracion.Conexion;
import com.modelo.Cita;

public class CitaDAO {
    //creamos las variables para conectar la base de datos
    Connection con;
    //creamos una instancia con la clase que creamos en el paquete setting
    Conexion conexion = new Conexion();
    //aqui preparamos la declaracion sql
    PreparedStatement preparedStatement;
    //aqui se retornan datos en las consultas sql
    ResultSet rs;
    PacienteDAO pdao = new PacienteDAO();
    MedicoDAO mdao = new MedicoDAO();

    public List<Cita> getCitas() {
        List<Cita> citas = new ArrayList<>();
        try {
            String sql = "select * from cita";
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getInt(1));
                c.setNombreCompleto(rs.getString(2));
                c.setIdentificacion(rs.getString(3));
                c.setFecha(rs.getDate(4));
                c.setSede(rs.getString(5));
                c.setPaciente(pdao.getPaciente(rs.getInt(6)));
                c.setMedico(mdao.getMedico(rs.getInt(7)));
                citas.add(c);
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

        return citas;
    }

    public List<Cita> getCitasDePaciente(int id) {
        List<Cita> citas = new ArrayList<>();
        try {
            String sql = "select * from cita where idPaciente = "+id;
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getInt(1));
                c.setNombreCompleto(rs.getString(2));
                c.setIdentificacion(rs.getString(3));
                c.setFecha(rs.getDate(4));
                c.setSede(rs.getString(5));
                c.setPaciente(pdao.getPaciente(rs.getInt(6)));
                c.setMedico(mdao.getMedico(rs.getInt(7)));
                citas.add(c);
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

        return citas;
    }

    public List<Cita> getCitasDeMedico(int id) {
        List<Cita> citas = new ArrayList<>();
        try {
            String sql = "select * from cita where idMedico = "+id;
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getInt(1));
                c.setNombreCompleto(rs.getString(2));
                c.setIdentificacion(rs.getString(3));
                c.setFecha(rs.getDate(4));
                c.setSede(rs.getString(5));
                c.setPaciente(pdao.getPaciente(rs.getInt(6)));
                c.setMedico(mdao.getMedico(rs.getInt(7)));
                citas.add(c);
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

        return citas;
    }
}