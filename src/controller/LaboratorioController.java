package controller;

import model.dao.LaboratorioDAO;
import model.entities.Laboratorio;
import java.util.List;

public class LaboratorioController {
    private LaboratorioDAO dao = new LaboratorioDAO();

    public List<Laboratorio> obtenerLaboratorios() {
        return dao.listarTodos();
    }
}
