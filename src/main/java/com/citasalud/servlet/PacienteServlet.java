package com.citasalud.servlet;

import com.citasalud.dao.PacienteDAO;
import com.citasalud.modelo.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/pacientes")
public class PacienteServlet extends HttpServlet {

    private PacienteDAO pacienteDAO;

    @Override
    public void init() {
        pacienteDAO = new PacienteDAO();
    }

    // Método GET: muestra la lista de pacientes
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/pacientes.jsp")
               .forward(request, response);
    }

    // Método POST: recibe los datos del formulario
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        Date fecha = null;

        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            fecha = Date.valueOf(fechaNacimiento);
        }

        Paciente paciente = new Paciente(
                tipoDocumento,
                numeroDocumento,
                nombres,
                apellidos,
                fecha,
                telefono,
                correo
        );

        pacienteDAO.insertar(paciente);

        response.sendRedirect("pacientes");
    }
}