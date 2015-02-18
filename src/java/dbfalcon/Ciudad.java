/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfalcon;

import java.io.Serializable;
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
 * @author sebastian
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCodCiudad", query = "SELECT c FROM Ciudad c WHERE c.codCiudad = :codCiudad"),
    @NamedQuery(name = "Ciudad.findByCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudad = :ciudad")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod ciudad")
    private Integer codCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinColumn(name = "Departamento_Cod_dep", referencedColumnName = "Cod_dep")
    @ManyToOne(optional = false)
    private Departamento departamentoCoddep;

    public Ciudad() {
    }

    public Ciudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Ciudad(Integer codCiudad, String ciudad) {
        this.codCiudad = codCiudad;
        this.ciudad = ciudad;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamentoCoddep() {
        return departamentoCoddep;
    }

    public void setDepartamentoCoddep(Departamento departamentoCoddep) {
        this.departamentoCoddep = departamentoCoddep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiudad != null ? codCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codCiudad == null && other.codCiudad != null) || (this.codCiudad != null && !this.codCiudad.equals(other.codCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Ciudad[ codCiudad=" + codCiudad + " ]";
    }
    
}
