/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.dao.espec;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Apoderado;

/**
 *
 * @author ErickOre
 */
public interface DaoApoderadoEspec extends DaoCrudEspec<Apoderado> {

    public List<String> getDniApos();
    
}
