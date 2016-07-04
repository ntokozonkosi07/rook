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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel( value = "Incident", description="Incident resource representation")
public class Incident implements Serializable {
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(value = "Entity Id", required = true)
    private int Id;
    @ApiModelProperty(value = "Entity name", required = true)
    private String Name;
    @OneToOne
    private PolygonType polygonType;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the polygonType
     */
    public PolygonType getPolygonType() {
        return polygonType;
    }

    /**
     * @param polygonType the polygonType to set
     */
    public void setPolygonType(PolygonType polygonType) {
        this.polygonType = polygonType;
    }
    
}
