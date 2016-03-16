/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Maestro;
import pe.eeob.ndrasistencias.service.MaestroService;

/**
 *
 * @author ErickOre
 */
public class MaestroController {
    
    MaestroService service;
    
    public MaestroController() {
        service = new MaestroService();
    }
    
    public List<Maestro> getMaestros(Maestro bean){
        return service.getMaestros(bean);
    }
    
}
