/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exerciciorest;

import Dao.DaoGenerico;
import Dao.VeiculoDao;
import Models.Veiculo;
import java.util.List;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author CamilaOdorizzi
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.exerciciorest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Secured({Permissao.ADMIN})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getJson(@PathParam("id") String id) {
        System.out.println("GET id..." + id);
        DaoGenerico dao = new DaoGenerico();
        long idCliente = Long.parseLong(id);
        Veiculo c = (Veiculo) dao.ler(Veiculo.class, idCliente);
        return c;
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getListaClientes() {
        VeiculoDao cd = new VeiculoDao();
        return cd.listar();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(Veiculo cliente){
        System.out.println("POST");
        System.out.println(cliente.getModelo());
        DaoGenerico dao = new DaoGenerico();
        dao.salvar(cliente);        
    }
}

