/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.controller;

import pe.eeob.ndrasistencias.domain.Maestro;
import pe.eeob.ndrasistencias.service.LogInService;
import pe.eeob.ndrasistencias.util.Memoria;

/**
 *
 * @author ErickOre
 */
public class LogInController {
    public void validar(String usuario, String clave){
        LogInService service = new LogInService();
        Maestro bean = service.validarService(usuario, clave);
        if (bean == null){
            throw new RuntimeException("Los datos ingresados no son válidos, intente de nuevo");
        } else {
            Memoria.put("usuario", bean);
        }
    }
}
