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
@Table(name = "ATENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a"),
    @NamedQuery(name = "Atencion.findByIdAten", query = "SELECT a FROM Atencion a WHERE a.idAten = :idAten"),
    @NamedQuery(name = "Atencion.findByDescripcion", query = "SELECT a FROM Atencion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Atencion.findByCosto", query = "SELECT a FROM Atencion a WHERE a.costo = :costo"),
    @NamedQuery(name = "Atencion.findByHora", query = "SELECT a FROM Atencion a WHERE a.hora = :hora"),
    @NamedQuery(name = "Atencion.findBySumatoriaComision", query = "SELECT a FROM Atencion a WHERE a.sumatoriaComision = :sumatoriaComision"),
    @NamedQuery(name = "Atencion.findByEstado", query = "SELECT a FROM Atencion a WHERE a.estado = :estado")})
public class Atencion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ATEN")
    private BigDecimal idAten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigInteger costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "HORA")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUMATORIA_COMISION")
    private BigInteger sumatoriaComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "PACIENTE_RUT", referencedColumnName = "RUT")
    @ManyToOne(optional = false)
    private Persona pacienteRut;
    @JoinColumn(name = "ID_ESPE", referencedColumnName = "ID_ESPE")
    @ManyToOne(optional = false)
    private Especialidad idEspe;
    @JoinColumn(name = "ID_BOLE", referencedColumnName = "ID_BOLE")
    @ManyToOne
    private Boleta idBole;
    @JoinColumn(name = "ID_AGEN", referencedColumnName = "ID_AGEN")
    @ManyToOne(optional = false)
    private Agenda idAgen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAten")
    private Collection<ComisionComprobante> comisionComprobanteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAten")
    private Collection<Pago> pagoCollection;

    public Atencion() {
    }

    public Atencion(BigDecimal idAten) {
        this.idAten = idAten;
    }

    public Atencion(BigDecimal idAten, String descripcion, BigInteger costo, String hora, BigInteger sumatoriaComision, String estado) {
        this.idAten = idAten;
        this.descripcion = descripcion;
        this.costo = costo;
        this.hora = hora;
        this.sumatoriaComision = sumatoriaComision;
        this.estado = estado;
    }

    public BigDecimal getIdAten() {
        return idAten;
    }

    public void setIdAten(BigDecimal idAten) {
        this.idAten = idAten;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public BigInteger getSumatoriaComision() {
        return sumatoriaComision;
    }

    public void setSumatoriaComision(BigInteger sumatoriaComision) {
        this.sumatoriaComision = sumatoriaComision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPacienteRut() {
        return pacienteRut;
    }

    public void setPacienteRut(Persona pacienteRut) {
        this.pacienteRut = pacienteRut;
    }

    public Especialidad getIdEspe() {
        return idEspe;
    }

    public void setIdEspe(Especialidad idEspe) {
        this.idEspe = idEspe;
    }

    public Boleta getIdBole() {
        return idBole;
    }

    public void setIdBole(Boleta idBole) {
        this.idBole = idBole;
    }

    public Agenda getIdAgen() {
        return idAgen;
    }

    public void setIdAgen(Agenda idAgen) {
        this.idAgen = idAgen;
    }

    @XmlTransient
    public Collection<ComisionComprobante> getComisionComprobanteCollection() {
        return comisionComprobanteCollection;
    }

    public void setComisionComprobanteCollection(Collection<ComisionComprobante> comisionComprobanteCollection) {
        this.comisionComprobanteCollection = comisionComprobanteCollection;
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
        hash += (idAten != null ? idAten.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.idAten == null && other.idAten != null) || (this.idAten != null && !this.idAten.equals(other.idAten))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Atencion[ idAten=" + idAten + " ]";
    }
    
}
