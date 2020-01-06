/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "TELEFONO_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoTipo.findAll", query = "SELECT t FROM TelefonoTipo t"),
    @NamedQuery(name = "TelefonoTipo.findByIdTeti", query = "SELECT t FROM TelefonoTipo t WHERE t.idTeti = :idTeti"),
    @NamedQuery(name = "TelefonoTipo.findByNombre", query = "SELECT t FROM TelefonoTipo t WHERE t.nombre = :nombre")})
public class TelefonoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TETI")
    private BigDecimal idTeti;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeti")
    private Collection<Telefono> telefonoCollection;

    public TelefonoTipo() {
    }

    public TelefonoTipo(BigDecimal idTeti) {
        this.idTeti = idTeti;
    }

    public TelefonoTipo(BigDecimal idTeti, String nombre) {
        this.idTeti = idTeti;
        this.nombre = nombre;
    }

    public BigDecimal getIdTeti() {
        return idTeti;
    }

    public void setIdTeti(BigDecimal idTeti) {
        this.idTeti = idTeti;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeti != null ? idTeti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoTipo)) {
            return false;
        }
        TelefonoTipo other = (TelefonoTipo) object;
        if ((this.idTeti == null && other.idTeti != null) || (this.idTeti != null && !this.idTeti.equals(other.idTeti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.TelefonoTipo[ idTeti=" + idTeti + " ]";
    }
    
}
