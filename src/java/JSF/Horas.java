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
@Table(name = "HORAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horas.findAll", query = "SELECT h FROM Horas h"),
    @NamedQuery(name = "Horas.findByIdHor", query = "SELECT h FROM Horas h WHERE h.idHor = :idHor"),
    @NamedQuery(name = "Horas.findByHorDia", query = "SELECT h FROM Horas h WHERE h.horDia = :horDia")})
public class Horas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HOR")
    private BigDecimal idHor;
    @Size(max = 30)
    @Column(name = "HOR_DIA")
    private String horDia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horasIdHor")
    private Collection<HorarioSemanal> horarioSemanalCollection;

    public Horas() {
    }

    public Horas(BigDecimal idHor) {
        this.idHor = idHor;
    }

    public BigDecimal getIdHor() {
        return idHor;
    }

    public void setIdHor(BigDecimal idHor) {
        this.idHor = idHor;
    }

    public String getHorDia() {
        return horDia;
    }

    public void setHorDia(String horDia) {
        this.horDia = horDia;
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
        hash += (idHor != null ? idHor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horas)) {
            return false;
        }
        Horas other = (Horas) object;
        if ((this.idHor == null && other.idHor != null) || (this.idHor != null && !this.idHor.equals(other.idHor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Horas[ idHor=" + idHor + " ]";
    }
    
}
