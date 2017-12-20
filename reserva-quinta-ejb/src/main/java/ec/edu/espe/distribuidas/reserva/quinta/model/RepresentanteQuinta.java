/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "representante_quinta")
@NamedQueries({
    @NamedQuery(name = "RepresentanteQuinta.findAll", query = "SELECT r FROM RepresentanteQuinta r")})
public class RepresentanteQuinta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_REPRESENTANTE")
    private Integer codRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION_REP")
    private String direccionRep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CARGO")
    private String cargo;
    @JoinColumn(name = "COD_QUINTA", referencedColumnName = "COD_QUINTA")
    @ManyToOne
    private Quinta codQuinta;

    public RepresentanteQuinta() {
    }

    public RepresentanteQuinta(Integer codRepresentante) {
        this.codRepresentante = codRepresentante;
    }

    public RepresentanteQuinta(Integer codRepresentante, String nombre, String apellido, String telefono, String direccionRep, String identificacion, String tipoIdentificacion, String cargo) {
        this.codRepresentante = codRepresentante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccionRep = direccionRep;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.cargo = cargo;
    }

    public Integer getCodRepresentante() {
        return codRepresentante;
    }

    public void setCodRepresentante(Integer codRepresentante) {
        this.codRepresentante = codRepresentante;
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

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
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
        int hash = 0;
        hash += (codRepresentante != null ? codRepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteQuinta)) {
            return false;
        }
        RepresentanteQuinta other = (RepresentanteQuinta) object;
        if ((this.codRepresentante == null && other.codRepresentante != null) || (this.codRepresentante != null && !this.codRepresentante.equals(other.codRepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.RepresentanteQuinta[ codRepresentante=" + codRepresentante + " ]";
    }
    
}
