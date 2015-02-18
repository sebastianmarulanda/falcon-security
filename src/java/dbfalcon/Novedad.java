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
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n"),
    @NamedQuery(name = "Novedad.findByCodnovedad", query = "SELECT n FROM Novedad n WHERE n.codnovedad = :codnovedad"),
    @NamedQuery(name = "Novedad.findByNovedad", query = "SELECT n FROM Novedad n WHERE n.novedad = :novedad")})
public class Novedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_novedad")
    private Integer codnovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Novedad")
    private String novedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codnovedad")
    private Collection<Observacion> observacionCollection;

    public Novedad() {
    }

    public Novedad(Integer codnovedad) {
        this.codnovedad = codnovedad;
    }

    public Novedad(Integer codnovedad, String novedad) {
        this.codnovedad = codnovedad;
        this.novedad = novedad;
    }

    public Integer getCodnovedad() {
        return codnovedad;
    }

    public void setCodnovedad(Integer codnovedad) {
        this.codnovedad = codnovedad;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
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
        hash += (codnovedad != null ? codnovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.codnovedad == null && other.codnovedad != null) || (this.codnovedad != null && !this.codnovedad.equals(other.codnovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Novedad[ codnovedad=" + codnovedad + " ]";
    }
    
}
