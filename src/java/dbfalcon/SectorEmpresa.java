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
@Table(name = "sector_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorEmpresa.findAll", query = "SELECT s FROM SectorEmpresa s"),
    @NamedQuery(name = "SectorEmpresa.findByCodsector", query = "SELECT s FROM SectorEmpresa s WHERE s.codsector = :codsector"),
    @NamedQuery(name = "SectorEmpresa.findBySector", query = "SELECT s FROM SectorEmpresa s WHERE s.sector = :sector")})
public class SectorEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_sector")
    private Integer codsector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Sector")
    private String sector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsector")
    private Collection<Usuariocliente> usuarioclienteCollection;

    public SectorEmpresa() {
    }

    public SectorEmpresa(Integer codsector) {
        this.codsector = codsector;
    }

    public SectorEmpresa(Integer codsector, String sector) {
        this.codsector = codsector;
        this.sector = sector;
    }

    public Integer getCodsector() {
        return codsector;
    }

    public void setCodsector(Integer codsector) {
        this.codsector = codsector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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
        hash += (codsector != null ? codsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorEmpresa)) {
            return false;
        }
        SectorEmpresa other = (SectorEmpresa) object;
        if ((this.codsector == null && other.codsector != null) || (this.codsector != null && !this.codsector.equals(other.codsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.SectorEmpresa[ codsector=" + codsector + " ]";
    }
    
}
