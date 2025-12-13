package controller;

import model.dao.LaboratorioDAO;
import model.entities.Laboratorio;
import java.util.List;

public class LaboratorioController {

    private LaboratorioDAO laboratorioDAO;

    public LaboratorioController() {
        this.laboratorioDAO = new LaboratorioDAO();
    }

    public List<Laboratorio> obtenerLaboratorios() {
        return laboratorioDAO.obtenerLaboratorios();
    }

    public Laboratorio obtenerLaboratorioPorId(int idLaboratorio) {
        try {
            return laboratorioDAO.obtenerLaboratorioPorId(idLaboratorio);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String obtenerNombreLaboratorio(int idLaboratorio) {
        try {
            Laboratorio laboratorio = laboratorioDAO.obtenerLaboratorioPorId(idLaboratorio);
            if (laboratorio != null) {
                return laboratorio.getNombre();
            } else {
                return "Laboratorio " + idLaboratorio; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Laboratorio " + idLaboratorio; 
        }
    }
}
