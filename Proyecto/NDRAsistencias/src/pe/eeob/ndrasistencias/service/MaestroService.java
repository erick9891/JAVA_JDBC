/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoMaestroEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoMaestroImpl;
import pe.eeob.ndrasistencias.domain.Maestro;

/**
 *
 * @author ErickOre
 */
public class MaestroService {

    DaoMaestroEspec dao;
    
    public MaestroService() {
        dao = new DaoMaestroImpl();
    }
    
    public List<Maestro> getMaestros(Maestro bean){
        return dao.readForCriteria(bean);
    }
    
}
