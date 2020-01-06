/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByNumero", query = "SELECT t FROM Telefono t WHERE t.numero = :numero"),
    @NamedQuery(name = "Telefono.findByDescripcion", query = "SELECT t FROM Telefono t WHERE t.descripcion = :descripcion")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TELEFONO")
    private BigDecimal idTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private BigInteger numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_TETI", referencedColumnName = "ID_TETI")
    @ManyToOne(optional = false)
    private TelefonoTipo idTeti;
    @JoinColumn(name = "RUT_PERS", referencedColumnName = "RUT")
    @ManyToOne(optional = false)
    private Persona rutPers;

    public Telefono() {
    }

    public Telefono(BigDecimal idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefono(BigDecimal idTelefono, BigInteger numero, String descripcion) {
        this.idTelefono = idTelefono;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(BigDecimal idTelefono) {
        this.idTelefono = idTelefono;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TelefonoTipo getIdTeti() {
        return idTeti;
    }

    public void setIdTeti(TelefonoTipo idTeti) {
        this.idTeti = idTeti;
    }

    public Persona getRutPers() {
        return rutPers;
    }

    public void setRutPers(Persona rutPers) {
        this.rutPers = rutPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Telefono[ idTelefono=" + idTelefono + " ]";
    }
    
}
