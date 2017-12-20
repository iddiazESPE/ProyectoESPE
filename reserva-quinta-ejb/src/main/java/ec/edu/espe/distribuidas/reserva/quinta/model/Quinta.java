/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "quinta")
@NamedQueries({
    @NamedQuery(name = "Quinta.findAll", query = "SELECT q FROM Quinta q")})
public class Quinta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_QUINTA")
    private Integer codQuinta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RUC_QUINTA")
    private String rucQuinta;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "COD_SERVICIO", referencedColumnName = "COD_SERVICIO")
    @ManyToOne(optional = false)
    private Servicio codServicio;
    @JoinColumn(name = "COD_SITIO", referencedColumnName = "COD_SITIO")
    @ManyToOne(optional = false)
    private Sitio codSitio;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL")
    @ManyToOne(optional = false)
    private Direccion codPostal;
    @OneToMany(mappedBy = "codQuinta")
    private List<RepresentanteQuinta> representanteQuintaList;
    @OneToMany(mappedBy = "codQuinta")
    private List<Reserva> reservaList;

    public Quinta() {
    }

    public Quinta(Integer codQuinta) {
        this.codQuinta = codQuinta;
    }

    public Quinta(Integer codQuinta, String razonSocial, String telefono, String rucQuinta, String email) {
        this.codQuinta = codQuinta;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.rucQuinta = rucQuinta;
        this.email = email;
    }

    public Integer getCodQuinta() {
        return codQuinta;
    }

    public void setCodQuinta(Integer codQuinta) {
        this.codQuinta = codQuinta;
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
        int hash = 0;
        hash += (codQuinta != null ? codQuinta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quinta)) {
            return false;
        }
        Quinta other = (Quinta) object;
        if ((this.codQuinta == null && other.codQuinta != null) || (this.codQuinta != null && !this.codQuinta.equals(other.codQuinta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Quinta[ codQuinta=" + codQuinta + " ]";
    }
    
}
