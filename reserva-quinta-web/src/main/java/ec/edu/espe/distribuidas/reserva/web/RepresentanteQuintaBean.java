/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidas.reserva.quinta.enums.TipoIdentificacionEnum;
import ec.edu.espe.distribuidas.reserva.quinta.model.RepresentanteQuinta;
import ec.edu.espe.distribuidas.reserva.quinta.service.RepresentanteQuintaService;
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
public class RepresentanteQuintaBean extends BaseBean implements Serializable {
    
    private List<RepresentanteQuinta> representantesQuinta;
    private RepresentanteQuinta representanteQuinta;
    private RepresentanteQuinta representanteQuintaSel;

    @Inject
    private RepresentanteQuintaService representanteQuintaService;

    @PostConstruct
    public void init() {
        this.representantesQuinta= this.representanteQuintaService.obtenerTodos();
        this.representanteQuinta= new RepresentanteQuinta();
    }

    public List<RepresentanteQuinta> getRepresentantesQuinta() {
        return representantesQuinta;
    }
    
    
    @Override
    public void agregar() {
        this.representanteQuinta= new RepresentanteQuinta();
        super.agregar();
        
    }
    @Override
    public void modificar() {
        super.modificar();
        this.representanteQuinta= new RepresentanteQuinta();
        this.representanteQuinta.setCodQuinta(this.representanteQuintaSel.getCodQuinta());
        this.representanteQuinta.setNombre(this.representanteQuintaSel.getNombre());
        this.representanteQuinta.setApellido(this.representanteQuintaSel.getApellido());
        this.representanteQuinta.setTelefono(this.representanteQuintaSel.getTelefono());
        this.representanteQuinta.setDireccionRep(this.representanteQuintaSel.getDireccionRep());        
        this.representanteQuinta.setTipoIdentificacion(this.representanteQuintaSel.getTipoIdentificacion());
        this.representanteQuinta.setIdentificacion(this.representanteQuintaSel.getIdentificacion());
        this.representanteQuinta.setCargo(this.representanteQuintaSel.getCargo());
        
    }
    
     public void eliminar() {
        try {
            this.representanteQuintaService.eliminar(this.representanteQuintaSel.getCodigo());
            this.representantesQuinta = this.representanteQuintaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.representanteQuintaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.representanteQuinta = this.representanteQuintaSel;
    }
    
    public void cancelar() {
        super.reset();
        this.representanteQuinta = new RepresentanteQuinta();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.representanteQuintaService.crear(this.representanteQuinta);
                FacesUtil.addMessageInfo("Se agregó el Representante: " + this.representanteQuinta.getNombre());
            } else {
                this.representanteQuintaService.modificar(this.representanteQuinta);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Representante con c\u00f3digo: " + this.representanteQuinta.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.representanteQuinta = new RepresentanteQuinta();
        this.representantesQuinta = this.representanteQuintaService.obtenerTodos();
    }

    public TipoIdentificacionEnum[] getTiposIdentificacion(){
        return TipoIdentificacionEnum.values();
    }
    
    public RepresentanteQuinta getRepresentanteQuinta() {
        return representanteQuinta;
    }

    public void setRepresentanteQuinta(RepresentanteQuinta representanteQuinta) {
        this.representanteQuinta = representanteQuinta;
    }

    public RepresentanteQuinta getRepresentanteQuintaSel() {
        return representanteQuintaSel;
    }

    public void setRepresentanteQuintaSel(RepresentanteQuinta representanteQuintaSel) {
        this.representanteQuintaSel = representanteQuintaSel;
    }
 
    
    
}
