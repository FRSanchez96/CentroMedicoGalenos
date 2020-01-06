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
@Table(name = "MEDIO_DE_PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioDePago.findAll", query = "SELECT m FROM MedioDePago m"),
    @NamedQuery(name = "MedioDePago.findByIdMediPago", query = "SELECT m FROM MedioDePago m WHERE m.idMediPago = :idMediPago"),
    @NamedQuery(name = "MedioDePago.findByNombre", query = "SELECT m FROM MedioDePago m WHERE m.nombre = :nombre")})
public class MedioDePago implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MEDI_PAGO")
    private BigDecimal idMediPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMediPago")
    private Collection<Pago> pagoCollection;

    public MedioDePago() {
    }

    public MedioDePago(BigDecimal idMediPago) {
        this.idMediPago = idMediPago;
    }

    public MedioDePago(BigDecimal idMediPago, String nombre) {
        this.idMediPago = idMediPago;
        this.nombre = nombre;
    }

    public BigDecimal getIdMediPago() {
        return idMediPago;
    }

    public void setIdMediPago(BigDecimal idMediPago) {
        this.idMediPago = idMediPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMediPago != null ? idMediPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioDePago)) {
            return false;
        }
        MedioDePago other = (MedioDePago) object;
        if ((this.idMediPago == null && other.idMediPago != null) || (this.idMediPago != null && !this.idMediPago.equals(other.idMediPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.MedioDePago[ idMediPago=" + idMediPago + " ]";
    }
    
}
