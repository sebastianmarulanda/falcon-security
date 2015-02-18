/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfalcon;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author sebastian
 */
@Entity
@Table(name = "usuariocliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariocliente.findAll", query = "SELECT u FROM Usuariocliente u"),
    @NamedQuery(name = "Usuariocliente.findById", query = "SELECT u FROM Usuariocliente u WHERE u.id = :id"),
    @NamedQuery(name = "Usuariocliente.findByCodcarnet", query = "SELECT u FROM Usuariocliente u WHERE u.codcarnet = :codcarnet"),
    @NamedQuery(name = "Usuariocliente.findByNombre", query = "SELECT u FROM Usuariocliente u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuariocliente.findByApellidos", query = "SELECT u FROM Usuariocliente u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuariocliente.findByCedula", query = "SELECT u FROM Usuariocliente u WHERE u.cedula = :cedula"),
    @NamedQuery(name = "Usuariocliente.findByEmail", query = "SELECT u FROM Usuariocliente u WHERE u.email = :email"),
    @NamedQuery(name = "Usuariocliente.findByDireccasa", query = "SELECT u FROM Usuariocliente u WHERE u.direccasa = :direccasa"),
    @NamedQuery(name = "Usuariocliente.findByTelefono", query = "SELECT u FROM Usuariocliente u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuariocliente.findByCiudad", query = "SELECT u FROM Usuariocliente u WHERE u.ciudad = :ciudad")})
public class Usuariocliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_carnet")
    private int codcarnet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula")
    private int cedula;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Direc_casa")
    private String direccasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacion")
    private Collection<UsuarioAutorizado> usuarioAutorizadoCollection;
    @JoinColumn(name = "Cod_dep", referencedColumnName = "Cod_dep")
    @ManyToOne(optional = false)
    private Departamento coddep;
    @JoinColumn(name = "Cod_sector", referencedColumnName = "Cod_sector")
    @ManyToOne(optional = false)
    private SectorEmpresa codsector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioclienteId")
    private Collection<Observacion> observacionCollection;

    public Usuariocliente() {
    }

    public Usuariocliente(Integer id) {
        this.id = id;
    }

    public Usuariocliente(Integer id, int codcarnet, String nombre, String apellidos, int cedula, String email, String direccasa, String telefono, String ciudad) {
        this.id = id;
        this.codcarnet = codcarnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.email = email;
        this.direccasa = direccasa;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodcarnet() {
        return codcarnet;
    }

    public void setCodcarnet(int codcarnet) {
        this.codcarnet = codcarnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccasa() {
        return direccasa;
    }

    public void setDireccasa(String direccasa) {
        this.direccasa = direccasa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<UsuarioAutorizado> getUsuarioAutorizadoCollection() {
        return usuarioAutorizadoCollection;
    }

    public void setUsuarioAutorizadoCollection(Collection<UsuarioAutorizado> usuarioAutorizadoCollection) {
        this.usuarioAutorizadoCollection = usuarioAutorizadoCollection;
    }

    public Departamento getCoddep() {
        return coddep;
    }

    public void setCoddep(Departamento coddep) {
        this.coddep = coddep;
    }

    public SectorEmpresa getCodsector() {
        return codsector;
    }

    public void setCodsector(SectorEmpresa codsector) {
        this.codsector = codsector;
    }

    @XmlTransient
    public Collection<Observacion> getObservacionCollection() {
        return observacionCollection;
    }

    public void setObservacionCollection(Collection<Observacion> observacionCollection) {
        this.observacionCollection = observacionCollection;
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
        if (!(object instanceof Usuariocliente)) {
            return false;
        }
        Usuariocliente other = (Usuariocliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Usuariocliente[ id=" + id + " ]";
    }
    
}
