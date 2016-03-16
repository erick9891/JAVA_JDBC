/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.practica0001.service;

import java.util.List;
import pe.eeob.practica0001.domain.Cliente;
import pe.eeob.practica0001.dao.espec.DaoClienteEspec;
import pe.eeob.practica0001.dao.impl.DaoClienteImpl;

/**
 *
 * @author ErickOre
 */
public class ClienteService {
    private DaoClienteEspec dao;

    public ClienteService() {
        dao = new DaoClienteImpl();
    }
    
    public List<Cliente> getClientes(Cliente bean){
        return dao.readForCriteria(bean);
    }

    
}
