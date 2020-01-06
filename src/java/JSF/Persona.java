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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByRut", query = "SELECT p FROM Persona p WHERE p.rut = :rut"),
    @NamedQuery(name = "Persona.findByVerificador", query = "SELECT p FROM Persona p WHERE p.verificador = :verificador"),
    @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Persona.findByApellidoPaterno", query = "SELECT p FROM Persona p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Persona.findByApellidoMaterno", query = "SELECT p FROM Persona p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByMail", query = "SELECT p FROM Persona p WHERE p.mail = :mail"),
    @NamedQuery(name = "Persona.findByContrasena", query = "SELECT p FROM Persona p WHERE p.contrasena = :contrasena")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private BigDecimal rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VERIFICADOR")
    private String verificador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @JoinTable(name = "DETALLE_TIPO_USUARIO", joinColumns = {
        @JoinColumn(name = "RUT_PERS", referencedColumnName = "RUT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USTI", referencedColumnName = "ID_USTI")})
    @ManyToMany
    private Collection<UsuarioTipo> usuarioTipoCollection;
    @JoinColumn(name = "SEXO_ID", referencedColumnName = "ID_SEXO")
    @ManyToOne(optional = false)
    private Sexo sexoId;
    @JoinColumn(name = "PREVISION_ID", referencedColumnName = "ID_PREVISION")
    @ManyToOne(optional = false)
    private Prevision previsionId;
    @JoinColumn(name = "COMUNA_ID", referencedColumnName = "ID_COMU")
    @ManyToOne(optional = false)
    private Comuna comunaId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteRut")
    private Collection<Atencion> atencionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutPers")
    private Collection<Telefono> telefonoCollection;

    public Persona() {
    }

    public Persona(BigDecimal rut) {
        this.rut = rut;
    }

    public Persona(BigDecimal rut, String verificador, String nombres, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String direccion, String mail, String contrasena) {
        this.rut = rut;
        this.verificador = verificador;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.mail = mail;
        this.contrasena = contrasena;
    }

    public BigDecimal getRut() {
        return rut;
    }

    public void setRut(BigDecimal rut) {
        this.rut = rut;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<UsuarioTipo> getUsuarioTipoCollection() {
        return usuarioTipoCollection;
    }

    public void setUsuarioTipoCollection(Collection<UsuarioTipo> usuarioTipoCollection) {
        this.usuarioTipoCollection = usuarioTipoCollection;
    }

    public Sexo getSexoId() {
        return sexoId;
    }

    public void setSexoId(Sexo sexoId) {
        this.sexoId = sexoId;
    }

    public Prevision getPrevisionId() {
        return previsionId;
    }

    public void setPrevisionId(Prevision previsionId) {
        this.previsionId = previsionId;
    }

    public Comuna getComunaId() {
        return comunaId;
    }

    public void setComunaId(Comuna comunaId) {
        this.comunaId = comunaId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @XmlTransient
    public Collection<Atencion> getAtencionCollection() {
        return atencionCollection;
    }

    public void setAtencionCollection(Collection<Atencion> atencionCollection) {
        this.atencionCollection = atencionCollection;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JSF.Persona[ rut=" + rut + " ]";
    }
    
}
