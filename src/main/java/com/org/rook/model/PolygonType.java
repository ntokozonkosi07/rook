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

/**
 *
 * @author ntokozo-nkosi
 */
@Entity
@ApiModel( value = "PolygonTyep", description="PolygonType resource representation")
public class PolygonType implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(value = "PolygonType Id", required = true)
    private int id;
    @ApiModelProperty(value = "PolygonType name", required = true)
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
