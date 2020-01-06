/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "COMISION_COMPROBANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComisionComprobante.findAll", query = "SELECT c FROM ComisionComprobante c"),
    @NamedQuery(name = "ComisionComprobante.findById", query = "SELECT c FROM ComisionComprobante c WHERE c.id = :id"),
    @NamedQuery(name = "ComisionComprobante.findByFecha", query = "SELECT c FROM ComisionComprobante c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ComisionComprobante.findByFirma", query = "SELECT c FROM ComisionComprobante c WHERE c.firma = :firma"),
    @NamedQuery(name = "ComisionComprobante.findByNumeroComprobante", query = "SELECT c FROM ComisionComprobante c WHERE c.numeroComprobante = :numeroComprobante")})
public class ComisionComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "FIRMA")
    private String firma;
    @Column(name = "NUMERO_COMPROBANTE")
    private Short numeroComprobante;
    @JoinColumn(name = "DOCTOR_RUT", referencedColumnName = "DOCTOR_RUT")
    @ManyToOne(optional = false)
    private Doctor doctorRut;
    @JoinColumn(name = "ID_ATEN", referencedColumnName = "ID_ATEN")
    @ManyToOne(optional = false)
    private Atencion idAten;

    public ComisionComprobante() {
    }

    public ComisionComprobante(BigDecimal id) {
        this.id = id;
    }

    public ComisionComprobante(BigDecimal id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Short getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(Short numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Doctor getDoctorRut() {
        return doctorRut;
    }

    public void setDoctorRut(Doctor doctorRut) {
        this.doctorRut = doctorRut;
    }

    public Atencion getIdAten() {
        return idAten;
    }

    public void setIdAten(Atencion idAten) {
        this.idAten = idAten;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionComprobante)) {
            return false;
        }
        ComisionComprobante other = (ComisionComprobante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.ComisionComprobante[ id=" + id + " ]";
    }
    
}
