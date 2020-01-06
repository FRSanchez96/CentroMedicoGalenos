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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "DOCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDoctorRut", query = "SELECT d FROM Doctor d WHERE d.doctorRut = :doctorRut"),
    @NamedQuery(name = "Doctor.findByEstado", query = "SELECT d FROM Doctor d WHERE d.estado = :estado")})
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCTOR_RUT")
    private BigDecimal doctorRut;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @Size(max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @JoinTable(name = "DETALLE_DOCTOR_ESPECIALIDAD", joinColumns = {
        @JoinColumn(name = "DOCTOR_RUT", referencedColumnName = "DOCTOR_RUT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ESPE", referencedColumnName = "ID_ESPE")})
    @ManyToMany
    private Collection<Especialidad> especialidadCollection;
    @JoinTable(name = "DETALLE_DOCTOR_SUCURSAL", joinColumns = {
        @JoinColumn(name = "DOCTOR_RUT", referencedColumnName = "DOCTOR_RUT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SUCU", referencedColumnName = "ID_SUCU")})
    @ManyToMany
    private Collection<Sucursal> sucursalCollection;
    @JoinColumn(name = "DOCTOR_RUT", referencedColumnName = "RUT", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "ID_HORA_SEM", referencedColumnName = "ID_HORA_SEM")
    @ManyToOne(optional = false)
    private HorarioSemanal idHoraSem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorRut")
    private Collection<Agenda> agendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorRut")
    private Collection<ComisionComprobante> comisionComprobanteCollection;

    public Doctor() {
    }

    public Doctor(BigDecimal doctorRut) {
        this.doctorRut = doctorRut;
    }

    public BigDecimal getDoctorRut() {
        return doctorRut;
    }

    public void setDoctorRut(BigDecimal doctorRut) {
        this.doctorRut = doctorRut;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Especialidad> getEspecialidadCollection() {
        return especialidadCollection;
    }

    public void setEspecialidadCollection(Collection<Especialidad> especialidadCollection) {
        this.especialidadCollection = especialidadCollection;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public HorarioSemanal getIdHoraSem() {
        return idHoraSem;
    }

    public void setIdHoraSem(HorarioSemanal idHoraSem) {
        this.idHoraSem = idHoraSem;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @XmlTransient
    public Collection<ComisionComprobante> getComisionComprobanteCollection() {
        return comisionComprobanteCollection;
    }

    public void setComisionComprobanteCollection(Collection<ComisionComprobante> comisionComprobanteCollection) {
        this.comisionComprobanteCollection = comisionComprobanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorRut != null ? doctorRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorRut == null && other.doctorRut != null) || (this.doctorRut != null && !this.doctorRut.equals(other.doctorRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Doctor[ doctorRut=" + doctorRut + " ]";
    }
    
}
