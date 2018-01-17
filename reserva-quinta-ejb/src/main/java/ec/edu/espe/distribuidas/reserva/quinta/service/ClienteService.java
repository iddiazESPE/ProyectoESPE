/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.ClienteFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Stateless
@LocalBean
public class ClienteService {
    @EJB
    private ClienteFacade ClienteFacade;
    
    public List<Cliente> obtenerTodos() {
        return this.ClienteFacade.findAll();
    }
    
    public Cliente obtenerPorCodigo(String codigo) {
        return this.ClienteFacade.find(codigo);
    }
    
    public void crear(Cliente cliente) {
        this.ClienteFacade.create(cliente);
    }
    
    public void modificar(Cliente cliente) {
        this.ClienteFacade.edit(cliente);
    }
    
    public void eliminar(Integer codigo) {
        Cliente cliente = this.ClienteFacade.find(codigo);
        this.ClienteFacade.remove(cliente);
    }
}
