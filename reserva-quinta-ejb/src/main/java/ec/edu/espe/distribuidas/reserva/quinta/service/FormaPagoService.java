/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.FormaPagoFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.FormaPago;
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
public class FormaPagoService {
    @EJB
    private FormaPagoFacade formaPagoFacade;
    
    public List<FormaPago> obtenerTodos() {
        return this.formaPagoFacade.findAll();
    }
    
    public FormaPago obtenerPorCodigo(String codigo) {
        return this.formaPagoFacade.find(codigo);
    }
    
    public void crear(FormaPago formaPago) {
        this.formaPagoFacade.create(formaPago);
    }
    
    public void modificar(FormaPago formaPago) {
        this.formaPagoFacade.edit(formaPago);
    }
    
    public void eliminar(String codigo) {
        FormaPago formaPago = this.formaPagoFacade.find(codigo);
        this.formaPagoFacade.remove(formaPago);
    }
}
