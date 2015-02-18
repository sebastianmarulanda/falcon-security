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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "usuario_autorizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAutorizado.findAll", query = "SELECT u FROM UsuarioAutorizado u"),
    @NamedQuery(name = "UsuarioAutorizado.findByCodAutorizado", query = "SELECT u FROM UsuarioAutorizado u WHERE u.codAutorizado = :codAutorizado"),
    @NamedQuery(name = "UsuarioAutorizado.findByUsuario", query = "SELECT u FROM UsuarioAutorizado u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioAutorizado.findByClave", query = "SELECT u FROM UsuarioAutorizado u WHERE u.clave = :clave")})
public class UsuarioAutorizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Autorizado")
    private Integer codAutorizado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Clave")
    private String clave;
    @JoinColumn(name = "Cod_Rol", referencedColumnName = "Cod_rol")
    @ManyToOne(optional = false)
    private Rol codRol;
    @JoinColumn(name = "Identificacion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuariocliente identificacion;

    public UsuarioAutorizado() {
    }

    public UsuarioAutorizado(Integer codAutorizado) {
        this.codAutorizado = codAutorizado;
    }

    public UsuarioAutorizado(Integer codAutorizado, String usuario, String clave) {
        this.codAutorizado = codAutorizado;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getCodAutorizado() {
        return codAutorizado;
    }

    public void setCodAutorizado(Integer codAutorizado) {
        this.codAutorizado = codAutorizado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    public Usuariocliente getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Usuariocliente identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAutorizado != null ? codAutorizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAutorizado)) {
            return false;
        }
        UsuarioAutorizado other = (UsuarioAutorizado) object;
        if ((this.codAutorizado == null && other.codAutorizado != null) || (this.codAutorizado != null && !this.codAutorizado.equals(other.codAutorizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.UsuarioAutorizado[ codAutorizado=" + codAutorizado + " ]";
    }
    
}
