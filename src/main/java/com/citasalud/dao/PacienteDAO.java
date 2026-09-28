package com.citasalud.dao;

import com.citasalud.conexion.ConexionBD;
import com.citasalud.modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Clase DAO encargada del acceso a los datos de los pacientes.
 * Contiene las operaciones necesarias para registrar, consultar,
 * actualizar y eliminar pacientes en la base de datos CITASALUD.
 */
public class PacienteDAO {

    public boolean insertar(Paciente paciente) {

        String sql = "INSERT INTO pacientes "
                + "(tipo_documento, numero_documento, nombres, apellidos, "
                + "fecha_nacimiento, telefono, correo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, paciente.getTipoDocumento());
            statement.setString(2, paciente.getNumeroDocumento());
            statement.setString(3, paciente.getNombres());
            statement.setString(4, paciente.getApellidos());
            statement.setDate(5, paciente.getFechaNacimiento());
            statement.setString(6, paciente.getTelefono());
            statement.setString(7, paciente.getCorreo());

            statement.executeUpdate();

            System.out.println("Paciente registrado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }
    public void consultar() {
    String sql = "SELECT * FROM pacientes";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql);
         ResultSet resultado = statement.executeQuery()) {

        System.out.println("LISTA DE PACIENTES:");

        while (resultado.next()) {
            System.out.println(
                "ID: " + resultado.getInt("id_paciente") +
                " | Documento: " + resultado.getString("numero_documento") +
                " | Nombre: " + resultado.getString("nombres") +
                " " + resultado.getString("apellidos") +
                " | Telefono: " + resultado.getString("telefono") +
                " | Correo: " + resultado.getString("correo")
            );
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar pacientes: " + e.getMessage());
    }
}

public boolean actualizar(int idPaciente, Paciente paciente) {

    String sql = "UPDATE pacientes SET tipo_documento = ?, numero_documento = ?, "
            + "nombres = ?, apellidos = ?, fecha_nacimiento = ?, telefono = ?, correo = ? "
            + "WHERE id_paciente = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setString(1, paciente.getTipoDocumento());
        statement.setString(2, paciente.getNumeroDocumento());
        statement.setString(3, paciente.getNombres());
        statement.setString(4, paciente.getApellidos());
        statement.setDate(5, paciente.getFechaNacimiento());
        statement.setString(6, paciente.getTelefono());
        statement.setString(7, paciente.getCorreo());
        statement.setInt(8, idPaciente);

        int filasActualizadas = statement.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Paciente actualizado correctamente.");
            return true;
        }

        System.out.println("No se encontro el paciente.");
        return false;

    } catch (SQLException e) {
        System.out.println("Error al actualizar paciente: " + e.getMessage());
        return false;
    }
}

public boolean eliminar(int idPaciente) {

    String sql = "DELETE FROM pacientes WHERE id_paciente = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setInt(1, idPaciente);

        int filasEliminadas = statement.executeUpdate();

        if (filasEliminadas > 0) {
            System.out.println("Paciente eliminado correctamente.");
            return true;
        }

        System.out.println("No se encontro el paciente.");
        return false;

    } catch (SQLException e) {
        System.out.println("Error al eliminar paciente: " + e.getMessage());
        return false;
    }
}
}