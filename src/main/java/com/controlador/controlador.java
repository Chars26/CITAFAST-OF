package com.controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.CitaDAO;
import com.dao.MedicoDAO;
import com.dao.PacienteDAO;
import com.dao.UsuarioDAO;
import com.modelo.Cita;
import com.modelo.Medico;
import com.modelo.Paciente;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class controlador extends HttpServlet {

    //creamos una instancia al objeto usuario
    Paciente paciente;
    //creamos una instancia e inicializamos al objeto usuarioDAO
    Medico medico;
    PacienteDAO pdao = new PacienteDAO();
    MedicoDAO mdao = new MedicoDAO();
    CitaDAO cdao = new CitaDAO();
    UsuarioDAO udao = new UsuarioDAO();

    //estas variables las creamos porque son redundantes en muchos metodos


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, java.text.ParseException {
        List<Cita> citas;
        Cita c;
        Paciente p;
        Medico m;
        String accion = request.getParameter("accion");
        //analizar bien
        String perfil = request.getSession().getAttribute("perfil") != null ? request.getSession().getAttribute("perfil").toString() : "";

        switch (accion) {
            //InfoCita()
            //ListarCitas()
            case "homePaciente":
                List<Cita> citasP = cdao.getCitasDePaciente(Paciente.class.cast(request.getSession().getAttribute("sesion")).getIdPaciente());
                request.setAttribute("citas", citasP);
                request.getRequestDispatcher("Vistas/vistaPac.jsp").forward(request, response);
                break;

            //** InfoCita()
            //** ListarCitas()
            case "homeMedico":
                List<Cita> citasM = cdao.getCitasDeMedico(Medico.class.cast(request.getSession().getAttribute("sesion")).getIdMedico());
                request.setAttribute("citas", citasM);
                request.getRequestDispatcher("Vistas/visMed.jsp").forward(request, response);
                break;

            case "login":
                String correo = request.getParameter("correo");
                String contrasena = request.getParameter("contrasena");
                Object obj = udao.login(correo, contrasena, request);
                if (obj != null) {
                    if (obj instanceof Paciente) {
                        request.getSession().setAttribute("perfil", "Paciente");
                        request.getRequestDispatcher("controlador?accion=homePaciente").forward(request, response);
                    } else {
                        request.getSession().setAttribute("perfil", "Medico");
                        request.getRequestDispatcher("controlador?accion=homeMedico").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                }
                break;

            case "logout":
                request.removeAttribute("citas");
                request.getSession().removeAttribute("perfil");
                request.getSession().removeAttribute("sesion");
                request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "registrar":
                perfil = request.getParameter("Paciente");
                boolean validacion;
                if (perfil == "Paciente") {
                    p = new Paciente();
                    p.setNombreCompleto(request.getParameter("nombreCompleto"));
                    p.setTipoDocumento(request.getParameter("tipoDocumento"));
                    p.setNumeroDocumento(request.getParameter("numeroDocumento"));
                    p.setTelefono(request.getParameter("telefono"));
                    p.setCorreo(request.getParameter("correo"));
                    p.setContrasena(request.getParameter("contrasena"));
                    validacion = udao.registrarPaciente(p);
                    if (validacion) {
                        request.getSession().setAttribute("sesion", p);
                        request.getSession().setAttribute("perfil", "Paciente");
                        request.getRequestDispatcher("controlador?accion=homePaciente").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                    }

                } else {
                    m = new Medico();
                    m.setNombreCompleto(request.getParameter("nombreCompleto"));
                    m.setEspecialidad(request.getParameter("especialidad"));
//                    m.setSede(request.getParameter("sede"));
                    m.setCorreo(request.getParameter("correo"));
                    m.setContrasena(request.getParameter("contrasena"));
                    validacion = udao.registrarMedico(m);
                    if (validacion) {
                        request.getSession().setAttribute("sesion", m);
                        request.getSession().setAttribute("perfil", "Medico");
                        request.getRequestDispatcher("controlador?accion=homeMedico").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                    }
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

                
                
            //** PedirCita()
            case "agregarCita":
                c = new Cita();
                c.setNombreCompleto(request.getParameter("nombreCompleto"));
                c.setIdentificacion(request.getParameter("identificacion"));
//                c.setSede(request.getParameter("sede"));
                c.setFecha(request.getParameter("fecha"));
                //JOptionPane.showMessageDialog(null, request.getParameter("fecha"));
                p = new Paciente();
                m = new Medico();
                p.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
                m.setIdMedico(Integer.parseInt(request.getParameter("idMedico")));
                c.setPaciente(p);
                c.setMedico(m);
                cdao.agregarCita(c);
                if (perfil == "Paciente") {
                    citas = cdao.getCitasDePaciente(Paciente.class.cast(request.getSession().getAttribute("sesion")).getIdPaciente());
                } else {
                    citas = cdao.getCitasDeMedico(Medico.class.cast(request.getSession().getAttribute("sesion")).getIdMedico());
                }
                request.setAttribute("citas", citas);
                //colocar la direccion a donde dirigir despues de
                request.getRequestDispatcher("Vistas/vistaPac.jsp").forward(request, response);
                break;

            //** EstadoCita()
            //** CambiarEstadoCita()
            case "editarCita":
                c = new Cita();
                c.setNombreCompleto(request.getParameter("nombreCompleto"));
                c.setIdentificacion(request.getParameter("identificacion"));
//                c.setSede(request.getParameter("sede"));
                c.setFecha(request.getParameter("fecha"));
                //JOptionPane.showMessageDialog(null, request.getParameter("fecha"));
                p = new Paciente();
                m = new Medico();
                p.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
                m.setIdMedico(Integer.parseInt(request.getParameter("idMedico")));
                c.setPaciente(p);
                c.setMedico(m);
                cdao.editarCita(c);
                if (perfil == "Paciente") {
                    citas = cdao.getCitasDePaciente(Paciente.class.cast(request.getSession().getAttribute("sesion")).getIdPaciente());
                } else {
                    citas = cdao.getCitasDeMedico(Medico.class.cast(request.getSession().getAttribute("sesion")).getIdMedico());
                }
                request.setAttribute("citas", citas);
                //colocar la direccion a donde dirigir despues de
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "eliminarCita":
                cdao.eliminarCita(Integer.parseInt(request.getParameter("idCita")));
                //colocar la direccion a donde dirigir despues de
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                
            case "solicitarCita":
                List <Medico> medico = mdao.getMedicos();
                request.setAttribute("medicos", medico);
                request.getRequestDispatcher("Vistas/solCita.jsp").forward(request, response);
                break;
                
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}