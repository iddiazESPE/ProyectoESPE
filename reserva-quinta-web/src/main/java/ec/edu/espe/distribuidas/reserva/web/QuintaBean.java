/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidas.reserva.quinta.model.Quinta;
import ec.edu.espe.distribuidas.reserva.quinta.model.Servicio;
import ec.edu.espe.distribuidas.reserva.quinta.service.QuintaService;
import ec.edu.espe.distribuidas.reserva.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author toshiba
 */
public class QuintaBean extends BaseBean implements Serializable {
    private List<Quinta> quintas;
    
    private Quinta quinta;
    
    private Quinta quintaSel;
    
    private String codigoBusqueda;
    
    
    @Inject
    private QuintaService quintaService;
    
    @PostConstruct
    public void init(){
        this.quintas= this.quintaService.obtenerTodos();
        this.quinta= new Quinta();
    }

    public List<Quinta> getQuintas() {
        return quintas;
    }
    
    @Override
    public void agregar() {
        this.quinta= new Quinta();
        super.agregar(); 
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.quinta = new Quinta();
        this.quinta.setCodigo(this.quintaSel.getCodigo());
        this.quinta.setCodServicio(this.quintaSel.getCodServicio());
        this.quinta.setCodSitio(this.quintaSel.getCodSitio());
        this.quinta.setCodPostal(this.quintaSel.getCodPostal());
        this.quinta.setRazonSocial(this.quintaSel.getRazonSocial());
        this.quinta.setTelefono(this.quintaSel.getTelefono());
        this.quinta.setRucQuinta(this.quintaSel.getRucQuinta());
        this.quinta.setEmail(this.quintaSel.getEmail());

    }

    public void eliminar() {
        try {
            this.quintaService.eliminar(this.quintaSel.getCodigo());
            this.quintas = this.quintaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.quintaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    public void cancelar() {
        super.reset();
        this.quinta = new Quinta();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.quintaService.crear(this.quinta);
                FacesUtil.addMessageInfo("Se agregó el Servicio: " + this.quinta.getRucQuinta());
            } else {
                this.quintaService.modificar(this.quinta);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Servicio con c\u00f3digo: " + this.quinta.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.quinta = new Quinta();
        this.quintas = this.quintaService.obtenerTodos();
    }
    
    public void buscar() {
        this.quintas = this.quintaService.buscarPorCodigo(codigoBusqueda);
    }
    
     public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }

    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }

    public Quinta getQuintaSel() {
        return quintaSel;
    }

    public void setQuintaSel(Quinta quintaSel) {
        this.quintaSel = quintaSel;
    }
    
    
        

}
