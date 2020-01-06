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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "USUARIO_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTipo.findAll", query = "SELECT u FROM UsuarioTipo u"),
    @NamedQuery(name = "UsuarioTipo.findByIdUsti", query = "SELECT u FROM UsuarioTipo u WHERE u.idUsti = :idUsti"),
    @NamedQuery(name = "UsuarioTipo.findByNombre", query = "SELECT u FROM UsuarioTipo u WHERE u.nombre = :nombre")})
public class UsuarioTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USTI")
    private BigDecimal idUsti;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @ManyToMany(mappedBy = "usuarioTipoCollection")
    private Collection<Persona> personaCollection;

    public UsuarioTipo() {
    }

    public UsuarioTipo(BigDecimal idUsti) {
        this.idUsti = idUsti;
    }

    public UsuarioTipo(BigDecimal idUsti, String nombre) {
        this.idUsti = idUsti;
        this.nombre = nombre;
    }

    public BigDecimal getIdUsti() {
        return idUsti;
    }

    public void setIdUsti(BigDecimal idUsti) {
        this.idUsti = idUsti;
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
        hash += (idUsti != null ? idUsti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTipo)) {
            return false;
        }
        UsuarioTipo other = (UsuarioTipo) object;
        if ((this.idUsti == null && other.idUsti != null) || (this.idUsti != null && !this.idUsti.equals(other.idUsti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.UsuarioTipo[ idUsti=" + idUsti + " ]";
    }
    
}
