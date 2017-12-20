/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tipo_sitio")
@NamedQueries({
    @NamedQuery(name = "TipoSitio.findAll", query = "SELECT t FROM TipoSitio t")})
public class TipoSitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_TIP_SITO")
    private String codTipSito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipSitio")
    private List<Sitio> sitioList;

    public TipoSitio() {
    }

    public TipoSitio(String codTipSito) {
        this.codTipSito = codTipSito;
    }

    public TipoSitio(String codTipSito, String descripcion) {
        this.codTipSito = codTipSito;
        this.descripcion = descripcion;
    }

    public String getCodTipSito() {
        return codTipSito;
    }

    public void setCodTipSito(String codTipSito) {
        this.codTipSito = codTipSito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipSito != null ? codTipSito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSitio)) {
            return false;
        }
        TipoSitio other = (TipoSitio) object;
        if ((this.codTipSito == null && other.codTipSito != null) || (this.codTipSito != null && !this.codTipSito.equals(other.codTipSito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.TipoSitio[ codTipSito=" + codTipSito + " ]";
    }
    
}
