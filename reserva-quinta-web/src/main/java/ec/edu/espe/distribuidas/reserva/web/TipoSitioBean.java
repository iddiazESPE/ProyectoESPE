/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidas.reserva.quinta.model.TipoSitio;
import ec.edu.espe.distribuidas.reserva.quinta.service.TipoSitioService;
import ec.edu.espe.distribuidas.hades.web.util.FacesUtil;
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
public class TipoSitioBean extends BaseBean implements Serializable {
    
    private List<TipoSitio> tiposSitios;

    private TipoSitio tipoSitio;

    private TipoSitio tipoSitioSel;

    @Inject
    private TipoSitioService tipoSitioService;

    @PostConstruct
    public void init() {
        this.tiposSitios = this.tipoSitioService.obtenerTodos();
        this.tipoSitio = new TipoSitio();
    }
    
    public List<TipoSitio> getTiposSitios() {
        return tiposSitios;
    }
    
    @Override
    public void agregar() {
        this.tipoSitio = new TipoSitio();
        super.agregar();
        
    }
    @Override
    public void modificar() {
        super.modificar();
        this.tipoSitio = new TipoSitio();
        this.tipoSitio.setCodigo(this.tipoSitioSel.getCodigo());
        this.tipoSitio.setDescripcion(this.tipoSitioSel.getDescripcion());
    }
    
     public void eliminar() {
        try {
            this.tipoSitioService.eliminar(this.tipoSitioSel.getCodigo());
            this.tiposSitios = this.tipoSitioService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.tipoSitioSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.tipoSitio = this.tipoSitioSel;
    }
    
    public void cancelar() {
        super.reset();
        this.tipoSitio = new TipoSitio();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoSitioService.crear(this.tipoSitio);
                FacesUtil.addMessageInfo("Se agregó el Tipo de Alimentaci\u00f3n: " + this.tipoSitio.getDescripcion());
            } else {
                this.tipoSitioService.modificar(this.tipoSitio);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Alimentaci\u00f3n con c\u00f3digo: " + this.tipoSitio.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.tipoSitio = new TipoSitio();
        this.tiposSitios = this.tipoSitioService.obtenerTodos();
    }
    
     public TipoSitio getTipoSitio() {
        return tipoSitio;
    }

    public void setTipoSitio(TipoSitio tipoSitio) {
        this.tipoSitio = tipoSitio;
    }

    public TipoSitio getTipoAlimentacionSel() {
        return tipoSitioSel;
    }

    public void setTipoSitioSel(TipoSitio tipoSitioSel) {
        this.tipoSitioSel = tipoSitioSel;
    }

}
