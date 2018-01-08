/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.ServicioFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.Servicio;
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
public class ServicioService {
    @EJB
    private ServicioFacade ServicioFacade;
    
    public List<Servicio> obtenerTodos() {
        return this.ServicioFacade.findAll();
    }
    
    public Servicio obtenerPorCodigo(String codigo) {
        return this.ServicioFacade.find(codigo);
    }
    
    public void crear(Servicio servicio) {
        this.ServicioFacade.create(servicio);
    }
    
    public void modificar(Servicio servicio) {
        this.ServicioFacade.edit(servicio);
    }
    
    public void eliminar(String codigo) {
        Servicio servicio = this.ServicioFacade.find(codigo);
        this.ServicioFacade.remove(servicio);
    }
}
