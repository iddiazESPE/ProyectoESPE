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

/**
 *
 * @author toshiba
 */
@Embeddable
public class ReservaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COD_RESERVA")
    private int codReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CLIENTE")
    private int codCliente;

    public ReservaPK() {
    }

    public ReservaPK(int codReserva, int codCliente) {
        this.codReserva = codReserva;
        this.codCliente = codCliente;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codReserva;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPK)) {
            return false;
        }
        ReservaPK other = (ReservaPK) object;
        if (this.codReserva != other.codReserva) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.ReservaPK[ codReserva=" + codReserva + ", codCliente=" + codCliente + " ]";
    }
    
}
