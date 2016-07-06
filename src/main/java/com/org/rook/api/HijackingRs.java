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
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;

/**
 *
 * @author ntokozo-nkosi
 */
@Path("/hijacking")
@Api(value = "/hijacking", description = "Manage hijacking hotspots")
public class HijackingRs {

    @GET
    @Path("/hotspots")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "List all accidents",
            notes = "List all accidents using paging",
            response = Hijacking.class,
            responseContainer = "List"
    )
    public List<Hijacking> readHijackingHotspots() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Hijacking> hijackingHotspots = session.createQuery("FROM Hijacking").list();
        session.close();
        System.out.println("Found " + hijackingHotspots.size() + " hijackingHotspots");
        return hijackingHotspots;
    }
}
