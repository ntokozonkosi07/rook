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
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel( value = "Construction", description="Construction resource representation")
public class Construction extends Incident implements Serializable{
    @OneToMany@OrderColumn
    @ApiModelProperty(value = "Construction location", required = true)    
    private Location[] location;

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

}
