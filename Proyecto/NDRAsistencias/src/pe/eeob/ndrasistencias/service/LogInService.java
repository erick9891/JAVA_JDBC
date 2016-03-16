/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import pe.eeob.ndrasistencias.dao.espec.DaoMaestroEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoMaestroImpl;
import pe.eeob.ndrasistencias.domain.Maestro;

/**
 *
 * @author ErickOre
 */
public class LogInService {
    public Maestro validarService(String usuario, String clave){
        Maestro bean = null;
        DaoMaestroEspec dao = new DaoMaestroImpl();
        bean = dao.validar(usuario, clave);
        return bean;
    }
}
