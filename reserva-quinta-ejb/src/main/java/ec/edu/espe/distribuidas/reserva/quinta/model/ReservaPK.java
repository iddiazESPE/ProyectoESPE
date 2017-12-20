/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Quinta Search
 */
@Embeddable
public class ReservaPK implements Serializable {

    @Column(name = "COD_RESERVA")
    private Integer codReserva;
 
    @Column(name = "COD_CLIENTE")
    private Integer codCliente;

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
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codReserva);
        hash = 11 * hash + Objects.hashCode(this.codCliente);
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
        final ReservaPK other = (ReservaPK) obj;
        if (!Objects.equals(this.codReserva, other.codReserva)) {
            return false;
        }
        if (!Objects.equals(this.codCliente, other.codCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.ReservaPK[ codReserva=" + codReserva + ", codCliente=" + codCliente + " ]";
    }
    
}
