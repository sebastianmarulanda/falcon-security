/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfalcon;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByCodpermiso", query = "SELECT p FROM Permiso p WHERE p.codpermiso = :codpermiso"),
    @NamedQuery(name = "Permiso.findByPermiso", query = "SELECT p FROM Permiso p WHERE p.permiso = :permiso")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_permiso")
    private Integer codpermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "permiso")
    private String permiso;
    @JoinTable(name = "rol_has_permiso", joinColumns = {
        @JoinColumn(name = "Cod_permiso", referencedColumnName = "Cod_permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "Cod_rol", referencedColumnName = "Cod_rol")})
    @ManyToMany
    private Collection<Rol> rolCollection;

    public Permiso() {
    }

    public Permiso(Integer codpermiso) {
        this.codpermiso = codpermiso;
    }

    public Permiso(Integer codpermiso, String permiso) {
        this.codpermiso = codpermiso;
        this.permiso = permiso;
    }

    public Integer getCodpermiso() {
        return codpermiso;
    }

    public void setCodpermiso(Integer codpermiso) {
        this.codpermiso = codpermiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpermiso != null ? codpermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codpermiso == null && other.codpermiso != null) || (this.codpermiso != null && !this.codpermiso.equals(other.codpermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Permiso[ codpermiso=" + codpermiso + " ]";
    }
    
}
