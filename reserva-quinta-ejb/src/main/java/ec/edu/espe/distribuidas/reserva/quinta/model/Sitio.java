/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
@Table(name = "sitio")
public class Sitio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_SITIO")
    private Integer codigo;
    
    @Column(name = "NUM_PERSONAS_PERMITIDAS" ,nullable = false, length = 3)
    private Integer numPersonasPermitidas;
    
    @JoinColumn(name = "COD_TIP_SITIO", referencedColumnName = "COD_TIP_SITO")
    @ManyToOne(optional = false)
    private TipoSitio codTipSitio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSitio")
    private List<Quinta> quintaList;

    public Sitio() {
    }

    public Sitio(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNumPersonasPermitidas() {
        return numPersonasPermitidas;
    }

    public void setNumPersonasPermitidas(Integer numPersonasPermitidas) {
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Sitio other = (Sitio) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sitio{" + "codigo=" + codigo + ", numPersonasPermitidas=" + numPersonasPermitidas + ", codTipSitio=" + codTipSitio + ", quintaList=" + quintaList + '}';
    }

}
