/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.api;

import com.org.rook.dal.DataAccess;
import com.org.rook.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ntokozo-nkosi
 */
@Path("/accidents")
@Api(value = "/accidents", description = "Manage accidents")
public class AccidentRs {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "List all accidents",
            notes = "List all accidents using paging",
            response = Accident.class,
            responseContainer = "List"
    )
    public ArrayList<Accident> readAccidents() {
        return (ArrayList<Accident>) new DataAccess().getAccidents();
    }

    public Accident createAccident() {
        return null;
    }

    private void simulateDataStorage() {
        DataAccess dal = new DataAccess();

        Accident a = new Accident();
        a.setName("A45-78");
        a.setDescription("Colision");

        Location loc = new Location();
        loc.setLatitude("454.485454");
        loc.setLongitude("54.445435");
        dal.createLocation(loc);

        a.setLocation(loc);

        dal.createAccident(a);

    }
}
