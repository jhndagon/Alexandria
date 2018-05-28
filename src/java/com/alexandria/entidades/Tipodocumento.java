/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author JDavid
 */
@Entity
@Table(name = "tipodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")
    , @NamedQuery(name = "Tipodocumento.findByIdtipoDocumento", query = "SELECT t FROM Tipodocumento t WHERE t.idtipoDocumento = :idtipoDocumento")
    , @NamedQuery(name = "Tipodocumento.findByNombre", query = "SELECT t FROM Tipodocumento t WHERE t.nombre = :nombre")})
public class Tipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoDocumento")
    private Integer idtipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodocumento")
    private Collection<Documento> documentoCollection;

    public Tipodocumento() {
    }

    public Tipodocumento(Integer idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    public Tipodocumento(Integer idtipoDocumento, String nombre) {
        this.idtipoDocumento = idtipoDocumento;
        this.nombre = nombre;
    }

    public Integer getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(Integer idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDocumento != null ? idtipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.idtipoDocumento == null && other.idtipoDocumento != null) || (this.idtipoDocumento != null && !this.idtipoDocumento.equals(other.idtipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.Tipodocumento[ idtipoDocumento=" + idtipoDocumento + " ]";
    }
    
}
