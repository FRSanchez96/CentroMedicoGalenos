/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "ATENCION_ESTADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtencionEstados.findAll", query = "SELECT a FROM AtencionEstados a"),
    @NamedQuery(name = "AtencionEstados.findByIdEstado", query = "SELECT a FROM AtencionEstados a WHERE a.idEstado = :idEstado"),
    @NamedQuery(name = "AtencionEstados.findByNombreEst", query = "SELECT a FROM AtencionEstados a WHERE a.nombreEst = :nombreEst")})
public class AtencionEstados implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO")
    private BigDecimal idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_EST")
    private String nombreEst;

    public AtencionEstados() {
    }

    public AtencionEstados(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public AtencionEstados(BigDecimal idEstado, String nombreEst) {
        this.idEstado = idEstado;
        this.nombreEst = nombreEst;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtencionEstados)) {
            return false;
        }
        AtencionEstados other = (AtencionEstados) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.AtencionEstados[ idEstado=" + idEstado + " ]";
    }
    
}
