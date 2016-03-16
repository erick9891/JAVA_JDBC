/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoApoderadoEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoApoderadoImpl;
import pe.eeob.ndrasistencias.domain.Apoderado;

/**
 *
 * @author ErickOre
 */
public class ApoderadoService {

    private DaoApoderadoEspec dao;
    
    public ApoderadoService() {
        dao = new DaoApoderadoImpl();
    }
    
    public List<Apoderado> getApoderados(Apoderado bean){
        return dao.readForCriteria(bean);
    }

    public List<String> getDniApos() {
        return dao.getDniApos();
    }
    
}
