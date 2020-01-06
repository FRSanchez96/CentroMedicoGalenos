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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdSucu", query = "SELECT s FROM Sucursal s WHERE s.idSucu = :idSucu"),
    @NamedQuery(name = "Sucursal.findByNombreSucu", query = "SELECT s FROM Sucursal s WHERE s.nombreSucu = :nombreSucu"),
    @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursal.findByNumeracion", query = "SELECT s FROM Sucursal s WHERE s.numeracion = :numeracion"),
    @NamedQuery(name = "Sucursal.findByCosteComision", query = "SELECT s FROM Sucursal s WHERE s.costeComision = :costeComision")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCU")
    private BigDecimal idSucu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_SUCU")
    private String nombreSucu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERACION")
    private BigInteger numeracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTE_COMISION")
    private BigInteger costeComision;
    @ManyToMany(mappedBy = "sucursalCollection")
    private Collection<Doctor> doctorCollection;
    @JoinColumn(name = "ID_COMU", referencedColumnName = "ID_COMU")
    @ManyToOne(optional = false)
    private Comuna idComu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucu")
    private Collection<Agenda> agendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucu")
    private Collection<HorarioSemanal> horarioSemanalCollection;

    public Sucursal() {
    }

    public Sucursal(BigDecimal idSucu) {
        this.idSucu = idSucu;
    }

    public Sucursal(BigDecimal idSucu, String nombreSucu, String direccion, BigInteger numeracion, BigInteger costeComision) {
        this.idSucu = idSucu;
        this.nombreSucu = nombreSucu;
        this.direccion = direccion;
        this.numeracion = numeracion;
        this.costeComision = costeComision;
    }

    public BigDecimal getIdSucu() {
        return idSucu;
    }

    public void setIdSucu(BigDecimal idSucu) {
        this.idSucu = idSucu;
    }

    public String getNombreSucu() {
        return nombreSucu;
    }

    public void setNombreSucu(String nombreSucu) {
        this.nombreSucu = nombreSucu;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(BigInteger numeracion) {
        this.numeracion = numeracion;
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

    public Comuna getIdComu() {
        return idComu;
    }

    public void setIdComu(Comuna idComu) {
        this.idComu = idComu;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @XmlTransient
    public Collection<HorarioSemanal> getHorarioSemanalCollection() {
        return horarioSemanalCollection;
    }

    public void setHorarioSemanalCollection(Collection<HorarioSemanal> horarioSemanalCollection) {
        this.horarioSemanalCollection = horarioSemanalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucu != null ? idSucu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucu == null && other.idSucu != null) || (this.idSucu != null && !this.idSucu.equals(other.idSucu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Sucursal[ idSucu=" + idSucu + " ]";
    }
    
}
