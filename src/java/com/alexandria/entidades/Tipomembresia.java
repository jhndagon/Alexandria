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
@Table(name = "tipomembresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomembresia.findAll", query = "SELECT t FROM Tipomembresia t")
    , @NamedQuery(name = "Tipomembresia.findByIdTipoMembresia", query = "SELECT t FROM Tipomembresia t WHERE t.idTipoMembresia = :idTipoMembresia")
    , @NamedQuery(name = "Tipomembresia.findByValor", query = "SELECT t FROM Tipomembresia t WHERE t.valor = :valor")
    , @NamedQuery(name = "Tipomembresia.findByDescripcion", query = "SELECT t FROM Tipomembresia t WHERE t.descripcion = :descripcion")})
public class Tipomembresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoMembresia")
    private Integer idTipoMembresia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMembresia")
    private Collection<Membresia> membresiaCollection;

    public Tipomembresia() {
    }

    public Tipomembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public Tipomembresia(Integer idTipoMembresia, double valor) {
        this.idTipoMembresia = idTipoMembresia;
        this.valor = valor;
    }

    public Integer getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Membresia> getMembresiaCollection() {
        return membresiaCollection;
    }

    public void setMembresiaCollection(Collection<Membresia> membresiaCollection) {
        this.membresiaCollection = membresiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMembresia != null ? idTipoMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomembresia)) {
            return false;
        }
        Tipomembresia other = (Tipomembresia) object;
        if ((this.idTipoMembresia == null && other.idTipoMembresia != null) || (this.idTipoMembresia != null && !this.idTipoMembresia.equals(other.idTipoMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.Tipomembresia[ idTipoMembresia=" + idTipoMembresia + " ]";
    }
    
}
