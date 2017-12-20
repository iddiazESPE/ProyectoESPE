/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Quinta Search
 */
@Entity
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    
    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;
  
    @Column(name = "VALOR_UNITARIO", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorUnitario;
    
    @Column(name = "VALOR_TOTAL", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorTotal;
    
    @JoinColumn(name = "COD_FACTURA", nullable = false, referencedColumnName = "COD_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;
    
    @JoinColumn(name = "COD_FOR_PAGO", referencedColumnName = "COD_FOR_PAGO")
    @ManyToOne
    private FormaPago codForPago;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(short codFactura, int codDetalle) {
        this.detalleFacturaPK = new DetalleFacturaPK(codFactura, codDetalle);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FormaPago getCodForPago() {
        return codForPago;
    }

    public void setCodForPago(FormaPago codForPago) {
        this.codForPago = codForPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "detalleFacturaPK=" + detalleFacturaPK + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", factura=" + factura + ", codForPago=" + codForPago + '}';
    }

    
}
