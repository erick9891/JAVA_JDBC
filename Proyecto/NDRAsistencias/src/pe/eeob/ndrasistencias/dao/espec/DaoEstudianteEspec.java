/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.dao.espec;

import java.util.List;
import pe.eeob.ndrasistencias.domain.Estudiante;

/**
 *
 * @author ErickOre
 */
public interface DaoEstudianteEspec extends DaoCrudEspec<Estudiante>{

    public List<String> getDniApo();
    
}
