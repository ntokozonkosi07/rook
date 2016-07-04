/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel( value = "Roadblock", description="Roadblock resource representation")
public class Roadblock extends Incident {
    @OneToOne
    @ApiModelProperty(value = "Roadblock location", required = true)
    private Location location;

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
}
