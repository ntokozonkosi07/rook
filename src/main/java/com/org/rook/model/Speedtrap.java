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
@ApiModel( value = "Speedtrap", description="Speedtrap resource representation")
public class Speedtrap extends Incident{
    @OneToOne
    @ApiModelProperty(value = "Speedtrap location", required = true)
    private Location location;
    @ApiModelProperty(value = "SpeedtrapType allocation", required = true)
    @OneToOne
    private SpeedtrapType speedTrapType;

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

    /**
     * @return the speedTrapType
     */
    public SpeedtrapType getSpeedTrapType() {
        return speedTrapType;
    }

    /**
     * @param speedTrapType the speedTrapType to set
     */
    public void setSpeedTrapType(SpeedtrapType speedTrapType) {
        this.speedTrapType = speedTrapType;
    }
}
