package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.configuracion.Conexion;
import com.modelo.Cita;
import com.modelo.Medico;

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
                c.setFecha(rs.getString(4));
//                c.setSede(rs.getString(5));
                c.setPaciente(pdao.getPaciente(rs.getInt(5)));
                c.setMedico(mdao.getMedico(rs.getInt(6)));
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
                c.setFecha(rs.getString(4));
                c.setPaciente(pdao.getPaciente(rs.getInt(5)));
                c.setMedico(mdao.getMedico(rs.getInt(6)));
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
                c.setFecha(rs.getString(4));
                c.setPaciente(pdao.getPaciente(rs.getInt(5)));
                c.setMedico(mdao.getMedico(rs.getInt(6)));
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
    

    public void agregarCita(Cita c) {
        try {
            String sql = "INSERT INTO `cita` (`Nombre Completo`, `Identificacion`, `Fecha`, `idPaciente`, `idMedico`) VALUES (?, ?, ?, ?, ?)";
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, c.getNombreCompleto());
            preparedStatement.setString(2, c.getIdentificacion());
            preparedStatement.setString(3,  c.getFecha());
//            preparedStatement.setString(4, c.gets());
            preparedStatement.setInt(4, c.getPaciente().getIdPaciente());
            preparedStatement.setInt(5, c.getMedico().getIdMedico());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void editarCita(Cita c) {
        try {
            String sql = "update cita set Nombre Completo=?, Identificacion=?, Fecha=?, idPaciente=?, idMedico=? where idCita="+c.getIdCita();
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, c.getNombreCompleto());
            preparedStatement.setString(2, c.getIdentificacion());
            preparedStatement.setString(3, c.getFecha());
//            preparedStatement.setString(4, c.getSede());
            preparedStatement.setString(4, c.getPaciente().getIdPaciente()+"");
            preparedStatement.setString(5, c.getMedico().getIdMedico()+"");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void eliminarCita(int id) {
        try {
            String sql = "delete from cita where idCita="+id;
            con = conexion.getConexion();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}