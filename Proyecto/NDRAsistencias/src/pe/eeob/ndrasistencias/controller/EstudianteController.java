/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Estudiante;
import pe.eeob.ndrasistencias.service.EstudianteService;
import pe.eeob.ndrasistencias.util.Ndr;

/**
 *
 * @author ErickOre
 */
public class EstudianteController {
    private EstudianteService service;

    public EstudianteController() {
        service = new EstudianteService();
    }
    
    public List<Estudiante> getEstudiantes(Estudiante bean){
        return service.getEstudiantes(bean);
    }
    
    public List<String> getDniApo(){
        return service.getDniApo();        
    }

    public void insertar(Estudiante bean) {
        service.insert(bean);
    }

    public void grabar(Estudiante bean, String accion) {
        switch(accion){     
          case Ndr.CRUD_EDITAR:
            service.update(bean);
            break;

          case Ndr.CRUD_ELIMINAR:
            service.delete(bean.getDni());
            break; 
        }        
    }
}
