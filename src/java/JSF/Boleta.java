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
@Table(name = "BOLETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b"),
    @NamedQuery(name = "Boleta.findByIdBole", query = "SELECT b FROM Boleta b WHERE b.idBole = :idBole"),
    @NamedQuery(name = "Boleta.findByTotal", query = "SELECT b FROM Boleta b WHERE b.total = :total"),
    @NamedQuery(name = "Boleta.findByFecha", query = "SELECT b FROM Boleta b WHERE b.fecha = :fecha")})
public class Boleta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BOLE")
    private BigDecimal idBole;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FECHA")
    private String fecha;
    @OneToMany(mappedBy = "idBole")
    private Collection<Atencion> atencionCollection;

    public Boleta() {
    }

    public Boleta(BigDecimal idBole) {
        this.idBole = idBole;
    }

    public Boleta(BigDecimal idBole, BigInteger total, String fecha) {
        this.idBole = idBole;
        this.total = total;
        this.fecha = fecha;
    }

    public BigDecimal getIdBole() {
        return idBole;
    }

    public void setIdBole(BigDecimal idBole) {
        this.idBole = idBole;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Atencion> getAtencionCollection() {
        return atencionCollection;
    }

    public void setAtencionCollection(Collection<Atencion> atencionCollection) {
        this.atencionCollection = atencionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBole != null ? idBole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBole == null && other.idBole != null) || (this.idBole != null && !this.idBole.equals(other.idBole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Boleta[ idBole=" + idBole + " ]";
    }
    
}
