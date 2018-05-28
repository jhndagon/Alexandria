/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JDavid
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIdDocumento", query = "SELECT d FROM Documento d WHERE d.documentoPK.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documento.findByIdtipoDocumento", query = "SELECT d FROM Documento d WHERE d.documentoPK.idtipoDocumento = :idtipoDocumento")
    , @NamedQuery(name = "Documento.findByCodigoPublicacion", query = "SELECT d FROM Documento d WHERE d.codigoPublicacion = :codigoPublicacion")
    , @NamedQuery(name = "Documento.findByTitulo", query = "SELECT d FROM Documento d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Documento.findByFechaPublicacion", query = "SELECT d FROM Documento d WHERE d.fechaPublicacion = :fechaPublicacion")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPK documentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigoPublicacion")
    private String codigoPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @JoinTable(name = "usuario_documento", joinColumns = {
        @JoinColumn(name = "idDocumento", referencedColumnName = "idDocumento")
        , @JoinColumn(name = "idtipoDocumento", referencedColumnName = "idtipoDocumento")}, inverseJoinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "documentoCollection")
    private Collection<Categoria> categoriaCollection;
    @ManyToMany(mappedBy = "documentoCollection")
    private Collection<Autor> autorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documento")
    private Collection<Calificacion> calificacionCollection;
    @JoinColumn(name = "idtipoDocumento", referencedColumnName = "idtipoDocumento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipodocumento tipodocumento;

    public Documento() {
    }

    public Documento(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(DocumentoPK documentoPK, String codigoPublicacion, String titulo, Date fechaPublicacion) {
        this.documentoPK = documentoPK;
        this.codigoPublicacion = codigoPublicacion;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Documento(int idDocumento, int idtipoDocumento) {
        this.documentoPK = new DocumentoPK(idDocumento, idtipoDocumento);
    }

    public DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public String getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(String codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @XmlTransient
    public Collection<Autor> getAutorCollection() {
        return autorCollection;
    }

    public void setAutorCollection(Collection<Autor> autorCollection) {
        this.autorCollection = autorCollection;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
