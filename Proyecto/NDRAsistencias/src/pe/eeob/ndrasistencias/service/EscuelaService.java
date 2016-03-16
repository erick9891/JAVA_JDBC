/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoEscuelaEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoEscuelaImpl;
import pe.eeob.ndrasistencias.domain.Escuela;

/**
 *
 * @author ErickOre
 */
public class EscuelaService {

    DaoEscuelaEspec dao;
    
    public EscuelaService() {
        dao = new DaoEscuelaImpl();
    }
    
    public List<Escuela> getEscuelas(Escuela bean){
        return dao.readForCriteria(bean);
    }
}
