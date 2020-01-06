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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "HORARIO_SEMANAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioSemanal.findAll", query = "SELECT h FROM HorarioSemanal h"),
    @NamedQuery(name = "HorarioSemanal.findByIdHoraSem", query = "SELECT h FROM HorarioSemanal h WHERE h.idHoraSem = :idHoraSem")})
public class HorarioSemanal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HORA_SEM")
    private BigDecimal idHoraSem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHoraSem")
    private Collection<Doctor> doctorCollection;
    @JoinColumn(name = "ID_SUCU", referencedColumnName = "ID_SUCU")
    @ManyToOne(optional = false)
    private Sucursal idSucu;
    @JoinColumn(name = "HORAS_ID_HOR", referencedColumnName = "ID_HOR")
    @ManyToOne(optional = false)
    private Horas horasIdHor;
    @JoinColumn(name = "ID_DIA", referencedColumnName = "ID_DIA")
    @ManyToOne(optional = false)
    private Dia idDia;

    public HorarioSemanal() {
    }

    public HorarioSemanal(BigDecimal idHoraSem) {
        this.idHoraSem = idHoraSem;
    }

    public BigDecimal getIdHoraSem() {
        return idHoraSem;
    }

    public void setIdHoraSem(BigDecimal idHoraSem) {
        this.idHoraSem = idHoraSem;
    }

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    public Sucursal getIdSucu() {
        return idSucu;
    }

    public void setIdSucu(Sucursal idSucu) {
        this.idSucu = idSucu;
    }

    public Horas getHorasIdHor() {
        return horasIdHor;
    }

    public void setHorasIdHor(Horas horasIdHor) {
        this.horasIdHor = horasIdHor;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoraSem != null ? idHoraSem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioSemanal)) {
            return false;
        }
        HorarioSemanal other = (HorarioSemanal) object;
        if ((this.idHoraSem == null && other.idHoraSem != null) || (this.idHoraSem != null && !this.idHoraSem.equals(other.idHoraSem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.HorarioSemanal[ idHoraSem=" + idHoraSem + " ]";
    }
    
}
