/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Escuela;
import pe.eeob.ndrasistencias.service.EscuelaService;

/**
 *
 * @author ErickOre
 */
public class EscuelaController {
    EscuelaService service;
    
    public EscuelaController() {
        service = new EscuelaService();
    }
    
    public List<Escuela> getEscuelas(Escuela bean){
        return service.getEscuelas(bean);
    }
}
