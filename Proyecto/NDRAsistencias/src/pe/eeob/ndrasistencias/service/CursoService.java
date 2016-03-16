/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoCursoEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoCursoImpl;
import pe.eeob.ndrasistencias.domain.Curso;

/**
 *
 * @author ErickOre
 */
public class CursoService {
    private DaoCursoEspec dao;

    public CursoService() {
        dao = new DaoCursoImpl();
    }
    
    public List<Curso> getCursos(Curso bean){
        return dao.readForCriteria(bean);
    }
    
    public List<Curso> getAllCursos(){
        return dao.readAll();
    }

    public List<String> getCursoPeriodo() {
        return dao.getCursoPeriodo();
    }
    
}
