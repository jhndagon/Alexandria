/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JDavid
 */
@Embeddable
public class CalificacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumento")
    private int idDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoDocumento")
    private int idtipoDocumento;

    public CalificacionPK() {
    }

    public CalificacionPK(int idUsuario, int idDocumento, int idtipoDocumento) {
        this.idUsuario = idUsuario;
        this.idDocumento = idDocumento;
        this.idtipoDocumento = idtipoDocumento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(int idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idDocumento;
        hash += (int) idtipoDocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionPK)) {
            return false;
        }
        CalificacionPK other = (CalificacionPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idDocumento != other.idDocumento) {
            return false;
        }
        if (this.idtipoDocumento != other.idtipoDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alexandria.entidades.CalificacionPK[ idUsuario=" + idUsuario + ", idDocumento=" + idDocumento + ", idtipoDocumento=" + idtipoDocumento + " ]";
    }
    
}
