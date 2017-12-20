/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import ec.edu.espe.distribuidas.reserva.quinta.enums.TipoIdentificacionEnum;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Quinta Search
 */
@Entity
@Table(name = "representante_quinta")
public class RepresentanteQuinta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_REPRESENTANTE")
    private Integer codigo;
    
    @Column(name = "NOMBRE" ,nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "APELLIDO" ,nullable = false, length = 100)
    private String apellido;
    
    @Column(name = "TELEFONO" ,nullable = false, length = 20)
    private String telefono;
    
    @Column(name = "DIRECCION_REP" ,nullable = false, length = 100)
    private String direccionRep;
    
    @Column(name = "IDENTIFICACION" ,nullable = false, length = 15)
    private String identificacion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_IDENTIFICACION" ,nullable = false, length = 3)
    private TipoIdentificacionEnum tipoIdentificacion;
    
    @Column(name = "CARGO" ,nullable = false, length = 100)
    private String cargo;
    
    @JoinColumn(name = "COD_QUINTA", referencedColumnName = "COD_QUINTA")
    @ManyToOne
    private Quinta codQuinta;

    public RepresentanteQuinta() {
    }

    public RepresentanteQuinta(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionRep() {
        return direccionRep;
    }

    public void setDireccionRep(String direccionRep) {
        this.direccionRep = direccionRep;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public TipoIdentificacionEnum getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionEnum tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Quinta getCodQuinta() {
        return codQuinta;
    }

    public void setCodQuinta(Quinta codQuinta) {
        this.codQuinta = codQuinta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final RepresentanteQuinta other = (RepresentanteQuinta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RepresentanteQuinta{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccionRep=" + direccionRep + ", identificacion=" + identificacion + ", tipoIdentificacion=" + tipoIdentificacion + ", cargo=" + cargo + ", codQuinta=" + codQuinta + '}';
    }

}
