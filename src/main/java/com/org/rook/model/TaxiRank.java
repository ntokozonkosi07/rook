/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel(value = "TaxiRank", description = "TaxiRank resource representation")
public class TaxiRank extends Incident implements Serializable {

    @ApiModelProperty(value = "TaxiRank location", required = true)
    @OneToOne
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
