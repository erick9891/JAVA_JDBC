/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.service;

import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoAulaEspec;
import pe.eeob.ndrasistencias.dao.implement.DaoAulaImpl;
import pe.eeob.ndrasistencias.domain.Aula;

/**
 *
 * @author ErickOre
 */
public class AulaService {
    DaoAulaEspec dao;
    public AulaService() {
        dao = new DaoAulaImpl();
    }
    public List<Aula> getAulas(Aula bean){
        return dao.readForCriteria(bean);
    }        
}
