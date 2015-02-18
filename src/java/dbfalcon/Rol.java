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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByCodrol", query = "SELECT r FROM Rol r WHERE r.codrol = :codrol"),
    @NamedQuery(name = "Rol.findByRol", query = "SELECT r FROM Rol r WHERE r.rol = :rol")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_rol")
    private Integer codrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Rol")
    private String rol;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Permiso> permisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codRol")
    private Collection<UsuarioAutorizado> usuarioAutorizadoCollection;

    public Rol() {
    }

    public Rol(Integer codrol) {
        this.codrol = codrol;
    }

    public Rol(Integer codrol, String rol) {
        this.codrol = codrol;
        this.rol = rol;
    }

    public Integer getCodrol() {
        return codrol;
    }

    public void setCodrol(Integer codrol) {
        this.codrol = codrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<UsuarioAutorizado> getUsuarioAutorizadoCollection() {
        return usuarioAutorizadoCollection;
    }

    public void setUsuarioAutorizadoCollection(Collection<UsuarioAutorizado> usuarioAutorizadoCollection) {
        this.usuarioAutorizadoCollection = usuarioAutorizadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrol != null ? codrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.codrol == null && other.codrol != null) || (this.codrol != null && !this.codrol.equals(other.codrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Rol[ codrol=" + codrol + " ]";
    }
    
}
