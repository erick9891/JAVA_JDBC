package pe.eeob.practica0001.controller;

import java.util.List;
import pe.eeob.practica0001.domain.Cliente;
import pe.eeob.practica0001.service.ClienteService;

/**
 *
 * @author ErickOre
 */
public class ClienteController {
    private ClienteService service;

    public ClienteController() {
        service = new ClienteService();
    }
    
    public List<Cliente> getClientes(Cliente bean){
        return service.getClientes(bean);
    }
}
