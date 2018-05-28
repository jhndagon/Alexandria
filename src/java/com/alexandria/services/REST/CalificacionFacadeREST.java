/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.services;

import com.alexandria.entidades.Calificacion;
import com.alexandria.entidades.CalificacionPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author JDavid
 */
@Stateless
@Path("com.alexandria.entidades.calificacion")
public class CalificacionFacadeREST extends AbstractFacade<Calificacion> {

    @PersistenceContext(unitName = "AlexandriaPU")
    private EntityManager em;

    private CalificacionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idUsuario=idUsuarioValue;idDocumento=idDocumentoValue;idtipoDocumento=idtipoDocumentoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.alexandria.entidades.CalificacionPK key = new com.alexandria.entidades.CalificacionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idUsuario = map.get("idUsuario");
        if (idUsuario != null && !idUsuario.isEmpty()) {
            key.setIdUsuario(new java.lang.Integer(idUsuario.get(0)));
        }
        java.util.List<String> idDocumento = map.get("idDocumento");
        if (idDocumento != null && !idDocumento.isEmpty()) {
            key.setIdDocumento(new java.lang.Integer(idDocumento.get(0)));
        }
        java.util.List<String> idtipoDocumento = map.get("idtipoDocumento");
        if (idtipoDocumento != null && !idtipoDocumento.isEmpty()) {
            key.setIdtipoDocumento(new java.lang.Integer(idtipoDocumento.get(0)));
        }
        return key;
    }

    public CalificacionFacadeREST() {
        super(Calificacion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Calificacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Calificacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.alexandria.entidades.CalificacionPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Calificacion find(@PathParam("id") PathSegment id) {
        com.alexandria.entidades.CalificacionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Calificacion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Calificacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
