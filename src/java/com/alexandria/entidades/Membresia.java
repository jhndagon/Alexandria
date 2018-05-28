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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JDavid
 */
@Entity
@Table(name = "membresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membresia.findAll", query = "SELECT m FROM Membresia m")
    , @NamedQuery(name = "Membresia.findByIdMembresia", query = "SELECT m FROM Membresia m WHERE m.idMembresia = :idMembresia")
    , @NamedQuery(name = "Membresia.findByValor", query = "SELECT m FROM Membresia m WHERE m.valor = :valor")})
public class Membresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMembresia")
    private Integer idMembresia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "idTipoMembresia", referencedColumnName = "idTipoMembresia")
    @ManyToOne(optional = false)
    private Tipomembresia idTipoMembresia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMembresia")
    private Collection<Usuario> usuarioCollection;

    public Membresia() {
    }

    public Membresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Membresia(Integer idMembresia, double valor) {
        this.idMembresia = idMembresia;
        this.valor = valor;
    }

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipomembresia getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(Tipomembresia idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembresia != null ? idMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membresia)) {
            return false;
        }
        Membresia other = (Membresia) object;
        if ((this.idMembresia == null && other.idMembresia != null) || (this.idMembresia != null && !this.idMembresia.equals(other.idMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.Membresia[ idMembresia=" + idMembresia + " ]";
    }
    
}
