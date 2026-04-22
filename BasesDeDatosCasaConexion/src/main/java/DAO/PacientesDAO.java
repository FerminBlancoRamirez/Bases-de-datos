package DAO;

import Modelo.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacientesDAO {
    List<Paciente> obtenerTodos();
    Optional<Paciente> obtenerPorId(String id);
    public void guardar(Paciente paciente);
    public void actualizar(Paciente paciente);
    public void eliminar(String id);
}
