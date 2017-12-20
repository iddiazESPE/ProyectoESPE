/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Quinta Search
 */
@Embeddable
public class CantonPK implements Serializable {

    @Column(name = "COD_PROVINCIA", nullable = false)
    private String codProvincia;
    
    @Column(name = "COD_CANTON", nullable = false)
    private String codCanton;

    public CantonPK() {
    }

    public CantonPK(String codProvincia, String codCanton) {
        this.codProvincia = codProvincia;
        this.codCanton = codCanton;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProvincia != null ? codProvincia.hashCode() : 0);
        hash += (codCanton != null ? codCanton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantonPK)) {
            return false;
        }
        CantonPK other = (CantonPK) object;
        if ((this.codProvincia == null && other.codProvincia != null) || (this.codProvincia != null && !this.codProvincia.equals(other.codProvincia))) {
            return false;
        }
        if ((this.codCanton == null && other.codCanton != null) || (this.codCanton != null && !this.codCanton.equals(other.codCanton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.CantonPK[ codProvincia=" + codProvincia + ", codCanton=" + codCanton + " ]";
    }
    
}
