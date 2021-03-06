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
@Table(name = "PREVISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByIdPrevision", query = "SELECT p FROM Prevision p WHERE p.idPrevision = :idPrevision"),
    @NamedQuery(name = "Prevision.findByNombre", query = "SELECT p FROM Prevision p WHERE p.nombre = :nombre")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PREVISION")
    private BigDecimal idPrevision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "previsionId")
    private Collection<Persona> personaCollection;

    public Prevision() {
    }

    public Prevision(BigDecimal idPrevision) {
        this.idPrevision = idPrevision;
    }

    public Prevision(BigDecimal idPrevision, String nombre) {
        this.idPrevision = idPrevision;
        this.nombre = nombre;
    }

    public BigDecimal getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(BigDecimal idPrevision) {
        this.idPrevision = idPrevision;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrevision != null ? idPrevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.idPrevision == null && other.idPrevision != null) || (this.idPrevision != null && !this.idPrevision.equals(other.idPrevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Prevision[ idPrevision=" + idPrevision + " ]";
    }
    
}
