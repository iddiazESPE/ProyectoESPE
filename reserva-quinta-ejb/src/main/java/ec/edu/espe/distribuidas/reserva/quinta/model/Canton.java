
package ec.edu.espe.distribuidas.reserva.quinta.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "canton")
public class Canton implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CantonPK cantonPK;
    
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    
    private List<Parroquia> parroquiaList;
    @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    
    private Provincia provincia;

    public Canton() {
    }

    public Canton(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public CantonPK getCantonPK() {
        return cantonPK;
    }

    public void setCantonPK(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Parroquia> getParroquiaList() {
        return parroquiaList;
    }

    public void setParroquiaList(List<Parroquia> parroquiaList) {
        this.parroquiaList = parroquiaList;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantonPK != null ? cantonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.cantonPK == null && other.cantonPK != null) || (this.cantonPK != null && !this.cantonPK.equals(other.cantonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.quinta.model.Canton[ cantonPK=" + cantonPK + " ]";
    }
    
}
