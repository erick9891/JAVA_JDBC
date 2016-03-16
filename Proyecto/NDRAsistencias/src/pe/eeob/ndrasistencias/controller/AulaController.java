/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Aula;
import pe.eeob.ndrasistencias.service.AulaService;

/**
 *
 * @author ErickOre
 */
public class AulaController {
    private AulaService service;
    
    public AulaController() {
        service = new AulaService();
    }
    
    public List<Aula> getAulas(Aula bean){
        return service.getAulas(bean);
    }
}
