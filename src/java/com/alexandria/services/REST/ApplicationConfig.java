/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexandria.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author JDavid
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.alexandria.services.AutorFacadeREST.class);
        resources.add(com.alexandria.services.CalificacionFacadeREST.class);
        resources.add(com.alexandria.services.CategoriaFacadeREST.class);
        resources.add(com.alexandria.services.DocumentoFacadeREST.class);
        resources.add(com.alexandria.services.MembresiaFacadeREST.class);
        resources.add(com.alexandria.services.REST.NewCrossOriginResourceSharingFilter.class);
        resources.add(com.alexandria.services.TipodocumentoFacadeREST.class);
        resources.add(com.alexandria.services.TipomembresiaFacadeREST.class);
        resources.add(com.alexandria.services.UsuarioFacadeREST.class);
    }
    
}
