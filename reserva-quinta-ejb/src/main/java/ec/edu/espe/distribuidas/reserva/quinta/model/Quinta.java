/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Quinta Search
 */
@Entity
@Table(name = "quinta")
public class Quinta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_QUINTA")
    private Integer codigo;
    
    @Column(name = "RAZON_SOCIAL" ,nullable = false, length = 100)
    private String razonSocial;
    
    @Column(name = "TELEFONO" ,nullable = false, length = 20)
    private String telefono;
    
    @Column(name = "RUC_QUINTA" ,nullable = false, length = 15)
    private String rucQuinta;
   
    @Column(name = "EMAIL" ,nullable = false, length = 100)
    private String email;
    
    @JoinColumn(name = "COD_SERVICIO", referencedColumnName = "COD_SERVICIO" ,insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio codServicio;
    
    @JoinColumn(name = "COD_SITIO", referencedColumnName = "COD_SITIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sitio codSitio;
    
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Direccion codPostal;
    
    @OneToMany(mappedBy = "codQuinta")
    private List<RepresentanteQuinta> representanteQuintaList;
    
    @OneToMany(mappedBy = "codQuinta")
    private List<Reserva> reservaList;

    public Quinta() {
    }

    public Quinta(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRucQuinta() {
        return rucQuinta;
    }

    public void setRucQuinta(String rucQuinta) {
        this.rucQuinta = rucQuinta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Servicio getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(Servicio codServicio) {
        this.codServicio = codServicio;
    }

    public Sitio getCodSitio() {
        return codSitio;
    }

    public void setCodSitio(Sitio codSitio) {
        this.codSitio = codSitio;
    }

    public Direccion getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Direccion codPostal) {
        this.codPostal = codPostal;
    }

    public List<RepresentanteQuinta> getRepresentanteQuintaList() {
        return representanteQuintaList;
    }

    public void setRepresentanteQuintaList(List<RepresentanteQuinta> representanteQuintaList) {
        this.representanteQuintaList = representanteQuintaList;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quinta other = (Quinta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quinta{" + "codigo=" + codigo + ", razonSocial=" + razonSocial + ", telefono=" + telefono + ", rucQuinta=" + rucQuinta + ", email=" + email + ", codServicio=" + codServicio + ", codSitio=" + codSitio + ", codPostal=" + codPostal + ", representanteQuintaList=" + representanteQuintaList + ", reservaList=" + reservaList + '}';
    }

}
