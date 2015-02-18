/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfalcon;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "observacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observacion.findAll", query = "SELECT o FROM Observacion o"),
    @NamedQuery(name = "Observacion.findByCodobservacion", query = "SELECT o FROM Observacion o WHERE o.codobservacion = :codobservacion"),
    @NamedQuery(name = "Observacion.findByHora", query = "SELECT o FROM Observacion o WHERE o.hora = :hora"),
    @NamedQuery(name = "Observacion.findByFecha", query = "SELECT o FROM Observacion o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Observacion.findByObservacion", query = "SELECT o FROM Observacion o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "Observacion.findByEvidencia", query = "SELECT o FROM Observacion o WHERE o.evidencia = :evidencia")})
public class Observacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_observacion")
    private Integer codobservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Evidencia")
    private String evidencia;
    @JoinColumn(name = "Cod_novedad", referencedColumnName = "Cod_novedad")
    @ManyToOne(optional = false)
    private Novedad codnovedad;
    @JoinColumn(name = "usuariocliente_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuariocliente usuarioclienteId;

    public Observacion() {
    }

    public Observacion(Integer codobservacion) {
        this.codobservacion = codobservacion;
    }

    public Observacion(Integer codobservacion, Date hora, Date fecha, String observacion, String evidencia) {
        this.codobservacion = codobservacion;
        this.hora = hora;
        this.fecha = fecha;
        this.observacion = observacion;
        this.evidencia = evidencia;
    }

    public Integer getCodobservacion() {
        return codobservacion;
    }

    public void setCodobservacion(Integer codobservacion) {
        this.codobservacion = codobservacion;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Novedad getCodnovedad() {
        return codnovedad;
    }

    public void setCodnovedad(Novedad codnovedad) {
        this.codnovedad = codnovedad;
    }

    public Usuariocliente getUsuarioclienteId() {
        return usuarioclienteId;
    }

    public void setUsuarioclienteId(Usuariocliente usuarioclienteId) {
        this.usuarioclienteId = usuarioclienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codobservacion != null ? codobservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.codobservacion == null && other.codobservacion != null) || (this.codobservacion != null && !this.codobservacion.equals(other.codobservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbfalcon.Observacion[ codobservacion=" + codobservacion + " ]";
    }
    
}
