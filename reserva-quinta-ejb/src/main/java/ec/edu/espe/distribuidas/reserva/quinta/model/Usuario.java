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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_USUARIO", nullable = false, length =15 )
    private String codUsuario;
   
    @Column(name = "NOMBRE", nullable = false, length =100)
    private String nombre;

    @Column(name = "CLAVE", nullable = false, length =32)
    private String clave;
    
    @Column(name = "EMAIL", nullable = false, length =100)
    private String email;

    public Usuario() {
    }

    public Usuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(String codUsuario, String nombre, String clave, String email) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Usuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
