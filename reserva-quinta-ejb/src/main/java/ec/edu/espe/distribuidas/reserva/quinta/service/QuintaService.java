/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.QuintaFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.Quinta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */

@Stateless
@LocalBean
public class QuintaService {
    
    @EJB
    private QuintaFacade quintaFacade;
    
    public List<Quinta> obtenerTodos() {
        return this.quintaFacade.findAll();
    }
    
    public Quinta obtenerPorCodigo(Integer codigo) {
        return this.quintaFacade.find(codigo);
    }
    
    public Quinta obtenerPorProvincia(String codigo) {
        return this.quintaFacade.find(codigo);
    }
    
    public List<Quinta> buscarPorCodigo (Integer codigoBusqueda){
        return this.quintaFacade.findByCodigo(codigoBusqueda);
    }
    
    /*public List<Quinta> buscarPorProvincia (String codigoPro){
        return this.quintaFacade.findByProvincia(codigoPro);
    }*/
    
    public void crear(Quinta quinta){
        this.quintaFacade.create(quinta);
    }
    
    public void modificar(Quinta quinta) {
        this.quintaFacade.edit(quinta);
    }
    
    public void eliminar(Integer codigo)
    {
        Quinta quinta = this.quintaFacade.find(codigo);
        this.quintaFacade.remove(quinta);
    }

    public List<Quinta> buscarPorCodigo(String codigoBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
}
