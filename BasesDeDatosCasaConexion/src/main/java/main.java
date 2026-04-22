import DAO.PacienteDAOImpl;
import DAO.PacientesDAO;

public class main {
    public static void main(String[] args) {
        PacientesDAO dao=new PacienteDAOImpl();
        System.out.println("Listar todos los pacientes");
        dao.obtenerTodos().forEach(System.out::println);
    }
}
