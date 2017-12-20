/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.TipoSitioFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.TipoSitio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Quinta Search
 */
@Stateless
@LocalBean
public class TipoSitioService {

    @EJB
    private TipoSitioFacade tipoSitioFacade;
    
    public List<TipoSitio> obtenerTodos() {
        return this.tipoSitioFacade.findAll();
    }
    
    public TipoSitio obtenerPorCodigo(String codigo) {
        return this.tipoSitioFacade.find(codigo);
    }
    
    public void crear(TipoSitio tipoSitio) {
        this.tipoSitioFacade.create(tipoSitio);
    }
    
    public void modificar(TipoSitio tipoSitio) {
        this.tipoSitioFacade.edit(tipoSitio);
    }
    
    public void eliminar(String codigo) {
        TipoSitio tipoSitio = this.tipoSitioFacade.find(codigo);
        this.tipoSitioFacade.remove(tipoSitio);
    }
}
