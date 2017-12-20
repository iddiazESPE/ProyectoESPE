/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "parroquia")
@NamedQueries({
    @NamedQuery(name = "Parroquia.findAll", query = "SELECT p FROM Parroquia p")})
public class Parroquia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParroquiaPK parroquiaPK;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "parroquia")
    private List<Direccion> direccionList;
    @JoinColumns({
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANTON", referencedColumnName = "COD_CANTON", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Canton canton;

    public Parroquia() {
    }

    public Parroquia(ParroquiaPK parroquiaPK) {
        this.parroquiaPK = parroquiaPK;
    }

    public Parroquia(String codProvincia, String codCanton, String codParroquia) {
        this.parroquiaPK = new ParroquiaPK(codProvincia, codCanton, codParroquia);
    }

    public ParroquiaPK getParroquiaPK() {
        return parroquiaPK;
    }

    public void setParroquiaPK(ParroquiaPK parroquiaPK) {
        this.parroquiaPK = parroquiaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parroquiaPK != null ? parroquiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parroquia)) {
            return false;
        }
        Parroquia other = (Parroquia) object;
        if ((this.parroquiaPK == null && other.parroquiaPK != null) || (this.parroquiaPK != null && !this.parroquiaPK.equals(other.parroquiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Parroquia[ parroquiaPK=" + parroquiaPK + " ]";
    }
    
}
