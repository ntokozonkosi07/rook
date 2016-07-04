/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel( value = "Traffic", description="Traffic resource representation")
public class Traffic extends Incident {

    @OneToMany
    @OrderColumn
    @ApiModelProperty(value = "Traffic jam location of type polyne(multiple points)", required = true)
    private Location[] location;
    @ApiModelProperty(value = "Traffic jam direction, uni/bi-direction", required = true)
    private String Direction;

    /**
     * @return the location
     */
    public Location[] getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location[] location) {
        this.location = location;
    }

    /**
     * @return the Direction
     */
    public String getDirection() {
        return Direction;
    }

    /**
     * @param Direction the Direction to set
     */
    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

}
