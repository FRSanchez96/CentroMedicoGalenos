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
@Table(name = "REGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdRegi", query = "SELECT r FROM Region r WHERE r.idRegi = :idRegi"),
    @NamedQuery(name = "Region.findByNombre", query = "SELECT r FROM Region r WHERE r.nombre = :nombre")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGI")
    private BigDecimal idRegi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais idPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegi")
    private Collection<Ciudad> ciudadCollection;

    public Region() {
    }

    public Region(BigDecimal idRegi) {
        this.idRegi = idRegi;
    }

    public Region(BigDecimal idRegi, String nombre) {
        this.idRegi = idRegi;
        this.nombre = nombre;
    }

    public BigDecimal getIdRegi() {
        return idRegi;
    }

    public void setIdRegi(BigDecimal idRegi) {
        this.idRegi = idRegi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegi != null ? idRegi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idRegi == null && other.idRegi != null) || (this.idRegi != null && !this.idRegi.equals(other.idRegi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Region[ idRegi=" + idRegi + " ]";
    }
    
}
