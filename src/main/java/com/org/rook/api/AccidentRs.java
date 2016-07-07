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
@Path("/accident")
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
}
