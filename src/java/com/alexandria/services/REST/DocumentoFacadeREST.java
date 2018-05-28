/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.services;

import com.alexandria.entidades.Documento;
import com.alexandria.entidades.DocumentoPK;
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
@Path("com.alexandria.entidades.documento")
public class DocumentoFacadeREST extends AbstractFacade<Documento> {

    @PersistenceContext(unitName = "AlexandriaPU")
    private EntityManager em;

    private DocumentoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idDocumento=idDocumentoValue;idtipoDocumento=idtipoDocumentoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.alexandria.entidades.DocumentoPK key = new com.alexandria.entidades.DocumentoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
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

    public DocumentoFacadeREST() {
        super(Documento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Documento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Documento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.alexandria.entidades.DocumentoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Documento find(@PathParam("id") PathSegment id) {
        com.alexandria.entidades.DocumentoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Documento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Documento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
