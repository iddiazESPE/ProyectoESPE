/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidas.reserva.quinta.model.Servicio;
import ec.edu.espe.distribuidas.reserva.quinta.service.ServicioService;
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
public class ServicioBean extends BaseBean implements Serializable {
    private List<Servicio> servicios;

    private Servicio servicio;

    private Servicio servicioSel;

    @Inject
    private ServicioService servicioService;

    @PostConstruct
    public void init() {
        this.servicios= this.servicioService.obtenerTodos();
        this.servicio= new Servicio();
    }

    public List<Servicio> getServicios() {
        return servicios;
    }
       
    @Override
    public void agregar() {
        this.servicio= new Servicio();
        super.agregar();
        
    }
    @Override
    public void modificar() {
        super.modificar();
        this.servicio= new Servicio();
        this.servicio.setCodigo(this.servicioSel.getCodigo());
        this.servicio.setDescripcion(this.servicioSel.getDescripcion());
    }
    
     public void eliminar() {
        try {
            this.servicioService.eliminar(this.servicioSel.getCodigo());
            this.servicios = this.servicioService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.servicioSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.servicio = this.servicioSel;
    }
    
    public void cancelar() {
        super.reset();
        this.servicio = new Servicio();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.servicioService.crear(this.servicio);
                FacesUtil.addMessageInfo("Se agregó el Servicio: " + this.servicio.getDescripcion());
            } else {
                this.servicioService.modificar(this.servicio);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Servicio con c\u00f3digo: " + this.servicio.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.servicio = new Servicio();
        this.servicios = this.servicioService.obtenerTodos();
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicioSel() {
        return servicioSel;
    }

    public void setServicioSel(Servicio servicioSel) {
        this.servicioSel = servicioSel;
    }

    

}
