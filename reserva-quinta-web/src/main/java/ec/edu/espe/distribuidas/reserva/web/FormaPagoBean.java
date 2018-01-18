/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidas.reserva.quinta.model.FormaPago;
import ec.edu.espe.distribuidas.reserva.quinta.service.FormaPagoService;
import ec.edu.espe.distribuidas.reserva.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Named
@ViewScoped
public class FormaPagoBean extends BaseBean implements Serializable {
     private List<FormaPago> formasPago;

    private FormaPago formaPago;

    private FormaPago formaPagoSel;

    @Inject
    private FormaPagoService formaPagoService;

    @PostConstruct
    public void init() {
        this.formasPago = this.formaPagoService.obtenerTodos();
        this.formaPago = new FormaPago();
    }

    public List<FormaPago> getFormasPago() {
        return formasPago;
    }
       
    @Override
    public void agregar() {
        this.formaPago = new FormaPago();
        super.agregar();
        
    }
    @Override
    public void modificar() {
        super.modificar();
        this.formaPago = new FormaPago();
        this.formaPago.setCodigo(this.formaPagoSel.getCodigo());
        this.formaPago.setDescripcion(this.formaPagoSel.getDescripcion());
        this.formaPago.setValor(this.formaPagoSel.getValor());
    }
    
     public void eliminar() {
        try {
            this.formaPagoService.eliminar(this.formaPagoSel.getCodigo());
            this.formasPago = this.formaPagoService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.formaPagoSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.formaPago = this.formaPagoSel;
    }
    
    public void cancelar() {
        super.reset();
        this.formaPago = new FormaPago();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.formaPagoService.crear(this.formaPago);
                FacesUtil.addMessageInfo("Se agregó el Tipo de Sitio: " + this.formaPago.getDescripcion());
            } else {
                this.formaPagoService.modificar(this.formaPago);
                FacesUtil.addMessageInfo("Se modific\u00f3 la forma ed pago con c\u00f3digo: " + this.formaPago.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.formaPago = new FormaPago();
        this.formasPago = this.formaPagoService.obtenerTodos();
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public FormaPago getFormaPagoSel() {
        return formaPagoSel;
    }

    public void setFormaPagoSel(FormaPago formaPagoSel) {
        this.formaPagoSel = formaPagoSel;
    }
    
 
    
}
