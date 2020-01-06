/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "FERIADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feriados.findAll", query = "SELECT f FROM Feriados f"),
    @NamedQuery(name = "Feriados.findByIdFeri", query = "SELECT f FROM Feriados f WHERE f.idFeri = :idFeri"),
    @NamedQuery(name = "Feriados.findByFecha", query = "SELECT f FROM Feriados f WHERE f.fecha = :fecha")})
public class Feriados implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FERI")
    private BigDecimal idFeri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFeri")
    private Collection<Pais> paisCollection;

    public Feriados() {
    }

    public Feriados(BigDecimal idFeri) {
        this.idFeri = idFeri;
    }

    public Feriados(BigDecimal idFeri, Date fecha) {
        this.idFeri = idFeri;
        this.fecha = fecha;
    }

    public BigDecimal getIdFeri() {
        return idFeri;
    }

    public void setIdFeri(BigDecimal idFeri) {
        this.idFeri = idFeri;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeri != null ? idFeri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feriados)) {
            return false;
        }
        Feriados other = (Feriados) object;
        if ((this.idFeri == null && other.idFeri != null) || (this.idFeri != null && !this.idFeri.equals(other.idFeri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Feriados[ idFeri=" + idFeri + " ]";
    }
    
}
