/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author toshiba
 */
@Embeddable
public class ParroquiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_PROVINCIA")
    private String codProvincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_CANTON")
    private String codCanton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_PARROQUIA")
    private String codParroquia;

    public ParroquiaPK() {
    }

    public ParroquiaPK(String codProvincia, String codCanton, String codParroquia) {
        this.codProvincia = codProvincia;
        this.codCanton = codCanton;
        this.codParroquia = codParroquia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(String codCanton) {
        this.codCanton = codCanton;
    }

    public String getCodParroquia() {
        return codParroquia;
    }

    public void setCodParroquia(String codParroquia) {
        this.codParroquia = codParroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProvincia != null ? codProvincia.hashCode() : 0);
        hash += (codCanton != null ? codCanton.hashCode() : 0);
        hash += (codParroquia != null ? codParroquia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParroquiaPK)) {
            return false;
        }
        ParroquiaPK other = (ParroquiaPK) object;
        if ((this.codProvincia == null && other.codProvincia != null) || (this.codProvincia != null && !this.codProvincia.equals(other.codProvincia))) {
            return false;
        }
        if ((this.codCanton == null && other.codCanton != null) || (this.codCanton != null && !this.codCanton.equals(other.codCanton))) {
            return false;
        }
        if ((this.codParroquia == null && other.codParroquia != null) || (this.codParroquia != null && !this.codParroquia.equals(other.codParroquia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.ParroquiaPK[ codProvincia=" + codProvincia + ", codCanton=" + codCanton + ", codParroquia=" + codParroquia + " ]";
    }
    
}
