/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JDavid
 */
@Entity
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdUsuario", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Calificacion.findByIdDocumento", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.idDocumento = :idDocumento")
    , @NamedQuery(name = "Calificacion.findByIdtipoDocumento", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.idtipoDocumento = :idtipoDocumento")
    , @NamedQuery(name = "Calificacion.findByEstrellas", query = "SELECT c FROM Calificacion c WHERE c.estrellas = :estrellas")
    , @NamedQuery(name = "Calificacion.findByResena", query = "SELECT c FROM Calificacion c WHERE c.resena = :resena")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estrellas")
    private int estrellas;
    @Size(max = 75)
    @Column(name = "resena")
    private String resena;
    @JoinColumns({
        @JoinColumn(name = "idDocumento", referencedColumnName = "idDocumento", insertable = false, updatable = false)
        , @JoinColumn(name = "idtipoDocumento", referencedColumnName = "idtipoDocumento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Documento documento;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Calificacion() {
    }

    public Calificacion(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Calificacion(CalificacionPK calificacionPK, int estrellas) {
        this.calificacionPK = calificacionPK;
        this.estrellas = estrellas;
    }

    public Calificacion(int idUsuario, int idDocumento, int idtipoDocumento) {
        this.calificacionPK = new CalificacionPK(idUsuario, idDocumento, idtipoDocumento);
    }

    public CalificacionPK getCalificacionPK() {
        return calificacionPK;
    }

    public void setCalificacionPK(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionPK != null ? calificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionPK == null && other.calificacionPK != null) || (this.calificacionPK != null && !this.calificacionPK.equals(other.calificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.Calificacion[ calificacionPK=" + calificacionPK + " ]";
    }
    
}
