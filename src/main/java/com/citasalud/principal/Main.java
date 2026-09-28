package com.citasalud.principal;

import com.citasalud.dao.PacienteDAO;
import com.citasalud.modelo.Paciente;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        Paciente paciente = new Paciente(
                "CC",
                "123456789",
                "Laura",
                "Gomez",
                Date.valueOf("1995-05-20"),
                "3001234567",
                "laura@gmail.com"
        );

        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.insertar(paciente);
    pacienteDAO.consultar();
    Paciente pacienteActualizado = new Paciente(
        "CC",
        "123456789",
        "Laura",
        "Martinez",
        Date.valueOf("1995-05-20"),
        "3119876543",
        "laura.martinez@gmail.com"
);

pacienteDAO.actualizar(1, pacienteActualizado);
pacienteDAO.consultar();
pacienteDAO.eliminar(3);
pacienteDAO.consultar();
   } 
}