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
import javax.persistence.ManyToMany;
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
@Table(name = "ESPECIALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByIdEspe", query = "SELECT e FROM Especialidad e WHERE e.idEspe = :idEspe"),
    @NamedQuery(name = "Especialidad.findByNombEspe", query = "SELECT e FROM Especialidad e WHERE e.nombEspe = :nombEspe"),
    @NamedQuery(name = "Especialidad.findByCantiModu", query = "SELECT e FROM Especialidad e WHERE e.cantiModu = :cantiModu"),
    @NamedQuery(name = "Especialidad.findByCosteComision", query = "SELECT e FROM Especialidad e WHERE e.costeComision = :costeComision")})
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESPE")
    private BigDecimal idEspe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMB_ESPE")
    private String nombEspe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTI_MODU")
    private BigInteger cantiModu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTE_COMISION")
    private BigInteger costeComision;
    @ManyToMany(mappedBy = "especialidadCollection")
    private Collection<Doctor> doctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspe")
    private Collection<Atencion> atencionCollection;

    public Especialidad() {
    }

    public Especialidad(BigDecimal idEspe) {
        this.idEspe = idEspe;
    }

    public Especialidad(BigDecimal idEspe, String nombEspe, BigInteger cantiModu, BigInteger costeComision) {
        this.idEspe = idEspe;
        this.nombEspe = nombEspe;
        this.cantiModu = cantiModu;
        this.costeComision = costeComision;
    }

    public BigDecimal getIdEspe() {
        return idEspe;
    }

    public void setIdEspe(BigDecimal idEspe) {
        this.idEspe = idEspe;
    }

    public String getNombEspe() {
        return nombEspe;
    }

    public void setNombEspe(String nombEspe) {
        this.nombEspe = nombEspe;
    }

    public BigInteger getCantiModu() {
        return cantiModu;
    }

    public void setCantiModu(BigInteger cantiModu) {
        this.cantiModu = cantiModu;
    }

    public BigInteger getCosteComision() {
        return costeComision;
    }

    public void setCosteComision(BigInteger costeComision) {
        this.costeComision = costeComision;
    }

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
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
        hash += (idEspe != null ? idEspe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idEspe == null && other.idEspe != null) || (this.idEspe != null && !this.idEspe.equals(other.idEspe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Especialidad[ idEspe=" + idEspe + " ]";
    }
    
}
