/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Apoderado;
import pe.eeob.ndrasistencias.service.ApoderadoService;

/**
 *
 * @author ErickOre
 */
public class ApoderadoController {

    private ApoderadoService service;
    
    public ApoderadoController() {
        service = new ApoderadoService();
    }
    
    public List<Apoderado> getApoderados(Apoderado bean){
        return service.getApoderados(bean);
    }

    public List<String> getDniApos() {
        return service.getDniApos();
    }
    
}
