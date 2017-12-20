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
public class DetalleFacturaPK implements Serializable {

    @Column(name = "COD_FACTURA", nullable = false)
    private short codFactura;
   
    @Column(name = "COD_DETALLE", nullable = false)
    private int codDetalle;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(short codFactura, int codDetalle) {
        this.codFactura = codFactura;
        this.codDetalle = codDetalle;
    }

    public short getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(short codFactura) {
        this.codFactura = codFactura;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codFactura;
        hash += (int) codDetalle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.codFactura != other.codFactura) {
            return false;
        }
        if (this.codDetalle != other.codDetalle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.DetalleFacturaPK[ codFactura=" + codFactura + ", codDetalle=" + codDetalle + " ]";
    }
    
}
