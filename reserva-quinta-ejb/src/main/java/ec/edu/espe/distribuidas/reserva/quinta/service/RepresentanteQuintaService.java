/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.RepresentanteQuintaFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.RepresentanteQuinta;
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
public class RepresentanteQuintaService {
    
    @EJB
    private RepresentanteQuintaFacade RepresentanteQuintaFacade;
    
    public List<RepresentanteQuinta> obtenerTodos() {
        return this.RepresentanteQuintaFacade.findAll();
    }
    
    public RepresentanteQuinta obtenerPorCodigo(String codigo) {
        return this.RepresentanteQuintaFacade.find(codigo);
    }
    
    public void crear(RepresentanteQuinta representanteQuinta) {
        this.RepresentanteQuintaFacade.create(representanteQuinta);
    }
    
    public void modificar(RepresentanteQuinta representanteQuinta) {
        this.RepresentanteQuintaFacade.edit(representanteQuinta);
    }
    
    public void eliminar(Integer codigo) {
        RepresentanteQuinta representanteQuinta = this.RepresentanteQuintaFacade.find(codigo);
        this.RepresentanteQuintaFacade.remove(representanteQuinta);
    }
      
}
