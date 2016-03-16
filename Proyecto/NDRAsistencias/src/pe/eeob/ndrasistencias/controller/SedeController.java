/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Sede;
import pe.eeob.ndrasistencias.service.SedeService;

/**
 *
 * @author ErickOre
 */
public class SedeController {
    private SedeService service;

    public SedeController() {
        service = new SedeService();
    }
    
    public List<Sede> getSedes(Sede bean){
        return service.getSedes(bean);
    }    
}
