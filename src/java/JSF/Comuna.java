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
@Table(name = "COMUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByIdComu", query = "SELECT c FROM Comuna c WHERE c.idComu = :idComu"),
    @NamedQuery(name = "Comuna.findByNombre", query = "SELECT c FROM Comuna c WHERE c.nombre = :nombre")})
public class Comuna implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMU")
    private BigDecimal idComu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunaId")
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComu")
    private Collection<Sucursal> sucursalCollection;
    @JoinColumn(name = "ID_CIUD", referencedColumnName = "ID_CIUD")
    @ManyToOne(optional = false)
    private Ciudad idCiud;

    public Comuna() {
    }

    public Comuna(BigDecimal idComu) {
        this.idComu = idComu;
    }

    public Comuna(BigDecimal idComu, String nombre) {
        this.idComu = idComu;
        this.nombre = nombre;
    }

    public BigDecimal getIdComu() {
        return idComu;
    }

    public void setIdComu(BigDecimal idComu) {
        this.idComu = idComu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
    }

    public Ciudad getIdCiud() {
        return idCiud;
    }

    public void setIdCiud(Ciudad idCiud) {
        this.idCiud = idCiud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComu != null ? idComu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.idComu == null && other.idComu != null) || (this.idComu != null && !this.idComu.equals(other.idComu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Comuna[ idComu=" + idComu + " ]";
    }
    
}
