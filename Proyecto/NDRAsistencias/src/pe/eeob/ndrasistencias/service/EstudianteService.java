/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoEstudianteEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoEstudianteImpl;
import pe.eeob.ndrasistencias.domain.Estudiante;

/**
 *
 * @author ErickOre
 */
public class EstudianteService {
    private DaoEstudianteEspec dao;

    public EstudianteService() {
        dao = new DaoEstudianteImpl();
    }
    
    public List<Estudiante> getEstudiantes(Estudiante bean){
        return dao.readForCriteria(bean);
    }

    public List<String> getDniApo() {
        return dao.getDniApo();
    }

    public void insert(Estudiante bean) {
        dao.insert(bean);
    }

    public void update(Estudiante bean) {
        dao.update(bean);
    }

    public void delete(String codigo) {
        dao.delete(codigo);
    }
    
}
