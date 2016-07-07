/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.api;

import static com.org.rook.dal.DataAccess.getSessionFactory;
import com.org.rook.model.Hijacking;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;

/**
 *
 * @author ntokozo-nkosi
 */
@Path("/hijacking")
@Api(value = "/hijacking", description = "Manage hijacking hotspots")
public class HijackingRs {


    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    @GET
    @Path(value = "/hotspot")
    @Produces(value = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List all accidents", notes = "List all accidents using paging", response = Hijacking.class, responseContainer = "List")
    public void readHijackingHotspots(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doReadHijackingHotspots());
            }
        });
    }

    @GET
    @Path(value = "/hotspot/{hotspotId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find accident by Id", notes = "List specific accident by Id", response = Hijacking.class, responseContainer = "List")
    public void readHijackingHotspots(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "hotspotId") final int hotspotId) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doReadHijackingHotspots(hotspotId));
            }
        });
    }

    
    private List<Hijacking> doReadHijackingHotspots() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
                List<Hijacking> hijackingHotspots = session.createQuery("FROM Hijacking").list();
        session.close();
        return hijackingHotspots;
    }

    private Hijacking doReadHijackingHotspots(@PathParam("hotspotId") int hotspotId) {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
                Hijacking hijackingHotspot;
        hijackingHotspot = (Hijacking) session.get(Hijacking.class, hotspotId);
        session.close();
        return hijackingHotspot;
    }

    @POST
    @Path(value = "/hotspot/create")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create Hotspot", notes = "Create new hijacking hospot")
    public void createHijackingHotspot(@Suspended final AsyncResponse asyncResponse, @ApiParam(value = "hotspot", required = true) final Hijacking hotspot) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                doCreateHijackingHotspot(hotspot);
                asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
            }
        });
    }

    private void doCreateHijackingHotspot(@ApiParam(value = "hotspot", required = true) Hijacking hotspot) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hotspot);
        session.getTransaction().commit();
    }
}
