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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Quinta Search
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_POSTAL", nullable = false, length = 8)
    private String codigo;
    
    @Column(name = "CALLE_PRINCIPAL", length = 100)
    private String callePrincipal;
    
    @Column(name = "CALLE_SECUNDARIA", length = 100)
    private String calleSecundaria;
   
    @Column(name = "REFERENCIA", length = 100)
    private String referencia;
    
    @Column(name = "NUM_CASA", length = 100)
    private String numCasa;
    
    private List<Quinta> quintaList;
    @JoinColumns({
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA"),
        @JoinColumn(name = "COD_CANTON", referencedColumnName = "COD_CANTON"),
        @JoinColumn(name = "COD_PARROQUIA", referencedColumnName = "COD_PARROQUIA")})
   
    @ManyToOne
    private Parroquia parroquia;

    public Direccion() {
    }

    public Direccion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Direccion other = (Direccion) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direccion{" + "codigo=" + codigo + ", callePrincipal=" + callePrincipal + ", calleSecundaria=" + calleSecundaria + ", referencia=" + referencia + ", numCasa=" + numCasa + ", quintaList=" + quintaList + ", parroquia=" + parroquia + '}';
    }

    
    
}
