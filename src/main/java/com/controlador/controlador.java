package com.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.dao.CitaDAO;
import com.dao.MedicoDAO;
import com.dao.PacienteDAO;
import com.dao.UsuarioDAO;
import com.modelo.Cita;
import com.modelo.Medico;
import com.modelo.Paciente;

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
            throws ServletException, IOException {
               // JOptionPane.showMessageDialog(null, "usuario: ");
        // Al llamar al servlet este es el primer metodo que se ejecuta(processRequest)
       // int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        //Se toma la variable que se envió por url
        String accion = request.getParameter("accion");
        //se determina que tipo de perfil es el usuario (paciente o medico)
        //String perfil = request.getParameter("perfil");
        //se buscan las citas del usuario
        //List<Cita> citas = perfil.equals("paciente") ? cdao.getCitasDePaciente(idUsuario) : cdao.getCitasDeMedico(idUsuario);
        //se crea un atributo del metodo request para poder mostrar variables en el front
        //request.setAttribute("citas", citas);
        switch (accion) {
            case "homePaciente":
                List<Cita> citasP = cdao.getCitasDePaciente(Paciente.class.cast(request.getSession().getAttribute("sesion")).getIdPaciente());
                request.setAttribute("citas", citasP);
                request.getRequestDispatcher("Vistas/vistaPac.jsp").forward(request, response);
                break;

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
                        request.getRequestDispatcher("controlador?accion=homePaciente").forward(request, response);
                    } else {
                        request.getRequestDispatcher("controlador?accion=homeMedico").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                }
                break;

            case "logout":
                request.removeAttribute("citas");
                request.getSession().removeAttribute("sesion");
                request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "registrar":
                String perfil = request.getParameter("perfil");
                request.removeAttribute("citas");
                boolean validacion;
                if (perfil == "Paciente") {
                    Paciente p = new Paciente();
                    p.setNombreCompleto(request.getParameter("nombreCompleto"));
                    p.setTipoDocumento(request.getParameter("tipoDocumento"));
                    p.setNumeroDocumento(request.getParameter("numeroDocumento"));
                    p.setTelefono(request.getParameter("telefono"));
                    p.setCorreo(request.getParameter("correo"));
                    p.setContrasena(request.getParameter("contrasena"));
                    validacion = udao.registrarPaciente(p);
                    if (validacion) {
                        request.getSession().setAttribute("sesion", p);
                        request.getRequestDispatcher("controlador?accion=homePaciente").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                    }

                } else {
                    Medico m = new Medico();
                    m.setNombreCompleto(request.getParameter("nombreCompleto"));
                    m.setEspecialidad(request.getParameter("especialidad"));
                    m.setSede(request.getParameter("sede"));
                    m.setCorreo(request.getParameter("correo"));
                    m.setContrasena(request.getParameter("contrasena"));
                    validacion = udao.registrarMedico(m);
                    if (validacion) {
                        request.getSession().setAttribute("sesion", m);
                        request.getRequestDispatcher("controlador?accion=homeMedico").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Vistas/registro.jsp").forward(request, response);
                    }
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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