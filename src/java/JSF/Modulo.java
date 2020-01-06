/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByIdModu", query = "SELECT m FROM Modulo m WHERE m.idModu = :idModu"),
    @NamedQuery(name = "Modulo.findByNombre", query = "SELECT m FROM Modulo m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Modulo.findByTiempo", query = "SELECT m FROM Modulo m WHERE m.tiempo = :tiempo")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODU")
    private BigDecimal idModu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO")
    private BigInteger tiempo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModu")
    private Collection<Agenda> agendaCollection;

    public Modulo() {
    }

    public Modulo(BigDecimal idModu) {
        this.idModu = idModu;
    }

    public Modulo(BigDecimal idModu, String nombre, BigInteger tiempo) {
        this.idModu = idModu;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public BigDecimal getIdModu() {
        return idModu;
    }

    public void setIdModu(BigDecimal idModu) {
        this.idModu = idModu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigInteger tiempo) {
        this.tiempo = tiempo;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModu != null ? idModu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.idModu == null && other.idModu != null) || (this.idModu != null && !this.idModu.equals(other.idModu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Modulo[ idModu=" + idModu + " ]";
    }
    
}
