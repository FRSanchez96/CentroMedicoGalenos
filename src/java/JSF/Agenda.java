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
@Table(name = "AGENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByIdAgen", query = "SELECT a FROM Agenda a WHERE a.idAgen = :idAgen"),
    @NamedQuery(name = "Agenda.findByFecha", query = "SELECT a FROM Agenda a WHERE a.fecha = :fecha")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AGEN")
    private BigDecimal idAgen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FECHA")
    private String fecha;
    @JoinColumn(name = "ID_SUCU", referencedColumnName = "ID_SUCU")
    @ManyToOne(optional = false)
    private Sucursal idSucu;
    @JoinColumn(name = "ID_MODU", referencedColumnName = "ID_MODU")
    @ManyToOne(optional = false)
    private Modulo idModu;
    @JoinColumn(name = "DOCTOR_RUT", referencedColumnName = "DOCTOR_RUT")
    @ManyToOne(optional = false)
    private Doctor doctorRut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgen")
    private Collection<Atencion> atencionCollection;

    public Agenda() {
    }

    public Agenda(BigDecimal idAgen) {
        this.idAgen = idAgen;
    }

    public Agenda(BigDecimal idAgen, String fecha) {
        this.idAgen = idAgen;
        this.fecha = fecha;
    }

    public BigDecimal getIdAgen() {
        return idAgen;
    }

    public void setIdAgen(BigDecimal idAgen) {
        this.idAgen = idAgen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Sucursal getIdSucu() {
        return idSucu;
    }

    public void setIdSucu(Sucursal idSucu) {
        this.idSucu = idSucu;
    }

    public Modulo getIdModu() {
        return idModu;
    }

    public void setIdModu(Modulo idModu) {
        this.idModu = idModu;
    }

    public Doctor getDoctorRut() {
        return doctorRut;
    }

    public void setDoctorRut(Doctor doctorRut) {
        this.doctorRut = doctorRut;
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
        hash += (idAgen != null ? idAgen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idAgen == null && other.idAgen != null) || (this.idAgen != null && !this.idAgen.equals(other.idAgen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Agenda[ idAgen=" + idAgen + " ]";
    }
    
}
