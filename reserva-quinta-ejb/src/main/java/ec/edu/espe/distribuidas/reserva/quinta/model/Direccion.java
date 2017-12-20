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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "direccion")
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_POSTAL")
    private String codPostal;
    @Size(max = 100)
    @Column(name = "CALLE_PRINCIPAL")
    private String callePrincipal;
    @Size(max = 100)
    @Column(name = "CALLE_SECUNDARIA")
    private String calleSecundaria;
    @Size(max = 100)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Size(max = 20)
    @Column(name = "NUM_CASA")
    private String numCasa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPostal")
    private List<Quinta> quintaList;
    @JoinColumns({
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA"),
        @JoinColumn(name = "COD_CANTON", referencedColumnName = "COD_CANTON"),
        @JoinColumn(name = "COD_PARROQUIA", referencedColumnName = "COD_PARROQUIA")})
    @ManyToOne
    private Parroquia parroquia;

    public Direccion() {
    }

    public Direccion(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public List<Quinta> getQuintaList() {
        return quintaList;
    }

    public void setQuintaList(List<Quinta> quintaList) {
        this.quintaList = quintaList;
    }

    public Parroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(Parroquia parroquia) {
        this.parroquia = parroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPostal != null ? codPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.codPostal == null && other.codPostal != null) || (this.codPostal != null && !this.codPostal.equals(other.codPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Direccion[ codPostal=" + codPostal + " ]";
    }
    
}
