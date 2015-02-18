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
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByCoddep", query = "SELECT d FROM Departamento d WHERE d.coddep = :coddep"),
    @NamedQuery(name = "Departamento.findByDepartamento", query = "SELECT d FROM Departamento d WHERE d.departamento = :departamento")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_dep")
    private Integer coddep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Departamento")
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoCoddep")
    private Collection<Ciudad> ciudadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddep")
    private Collection<Usuariocliente> usuarioclienteCollection;

    public Departamento() {
    }

    public Departamento(Integer coddep) {
        this.coddep = coddep;
    }

    public Departamento(Integer coddep, String departamento) {
        this.coddep = coddep;
        this.departamento = departamento;
    }

    public Integer getCoddep() {
        return coddep;
    }

    public void setCoddep(Integer coddep) {
        this.coddep = coddep;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @XmlTransient
    public Collection<Usuariocliente> getUsuarioclienteCollection() {
        return usuarioclienteCollection;
    }

    public void setUsuarioclienteCollection(Collection<Usuariocliente> usuarioclienteCollection) {
        this.usuarioclienteCollection = usuarioclienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddep != null ? coddep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.coddep == null && other.coddep != null) || (this.coddep != null && !this.coddep.equals(other.coddep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Departamento[ coddep=" + coddep + " ]";
    }
    
}
