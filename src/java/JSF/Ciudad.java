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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiud", query = "SELECT c FROM Ciudad c WHERE c.idCiud = :idCiud"),
    @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CIUD")
    private BigDecimal idCiud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "ID_REGI", referencedColumnName = "ID_REGI")
    @ManyToOne(optional = false)
    private Region idRegi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiud")
    private Collection<Comuna> comunaCollection;

    public Ciudad() {
    }

    public Ciudad(BigDecimal idCiud) {
        this.idCiud = idCiud;
    }

    public Ciudad(BigDecimal idCiud, String nombre) {
        this.idCiud = idCiud;
        this.nombre = nombre;
    }

    public BigDecimal getIdCiud() {
        return idCiud;
    }

    public void setIdCiud(BigDecimal idCiud) {
        this.idCiud = idCiud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Region getIdRegi() {
        return idRegi;
    }

    public void setIdRegi(Region idRegi) {
        this.idRegi = idRegi;
    }

    @XmlTransient
    public Collection<Comuna> getComunaCollection() {
        return comunaCollection;
    }

    public void setComunaCollection(Collection<Comuna> comunaCollection) {
        this.comunaCollection = comunaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiud != null ? idCiud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiud == null && other.idCiud != null) || (this.idCiud != null && !this.idCiud.equals(other.idCiud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Ciudad[ idCiud=" + idCiud + " ]";
    }
    
}
