/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoSedeEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoSedeImpl;
import pe.eeob.ndrasistencias.domain.Sede;

/**
 *
 * @author ErickOre
 */
public class SedeService {
    private DaoSedeEspec dao;

    public SedeService() {
        dao = new DaoSedeImpl();
    }
    
    public List<Sede> getSedes(Sede bean){
        return dao.readForCriteria(bean);
    }    
}
