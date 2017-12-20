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

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "sitio")
@NamedQueries({
    @NamedQuery(name = "Sitio.findAll", query = "SELECT s FROM Sitio s")})
public class Sitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SITIO")
    private Integer codSitio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PERSONAS_PERMITIDAS")
    private short numPersonasPermitidas;
    @JoinColumn(name = "COD_TIP_SITIO", referencedColumnName = "COD_TIP_SITO")
    @ManyToOne(optional = false)
    private TipoSitio codTipSitio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSitio")
    private List<Quinta> quintaList;

    public Sitio() {
    }

    public Sitio(Integer codSitio) {
        this.codSitio = codSitio;
    }

    public Sitio(Integer codSitio, short numPersonasPermitidas) {
        this.codSitio = codSitio;
        this.numPersonasPermitidas = numPersonasPermitidas;
    }

    public Integer getCodSitio() {
        return codSitio;
    }

    public void setCodSitio(Integer codSitio) {
        this.codSitio = codSitio;
    }

    public short getNumPersonasPermitidas() {
        return numPersonasPermitidas;
    }

    public void setNumPersonasPermitidas(short numPersonasPermitidas) {
        this.numPersonasPermitidas = numPersonasPermitidas;
    }

    public TipoSitio getCodTipSitio() {
        return codTipSitio;
    }

    public void setCodTipSitio(TipoSitio codTipSitio) {
        this.codTipSitio = codTipSitio;
    }

    public List<Quinta> getQuintaList() {
        return quintaList;
    }

    public void setQuintaList(List<Quinta> quintaList) {
        this.quintaList = quintaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSitio != null ? codSitio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sitio)) {
            return false;
        }
        Sitio other = (Sitio) object;
        if ((this.codSitio == null && other.codSitio != null) || (this.codSitio != null && !this.codSitio.equals(other.codSitio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Sitio[ codSitio=" + codSitio + " ]";
    }
    
}
