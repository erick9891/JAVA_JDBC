/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Curso;
import pe.eeob.ndrasistencias.service.CursoService;

/**
 *
 * @author ErickOre
 */
public class CursoController {
    private CursoService service;

    public CursoController() {
        service = new CursoService();
    }
    
    public List<Curso> getCursos(Curso bean){
        return service.getCursos(bean);
    }
    
    public List<Curso> getAllCursos(){
        return service.getAllCursos();
    }

    public List<String> getCursoPeriodo() {
        return service.getCursoPeriodo();
    }
}
