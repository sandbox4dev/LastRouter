package com.dev;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vyacheslav on 22.11.2016.
 */
public class JsonResult {
    //Params as Json params
    @JsonProperty
    private int dep_sid;
    @JsonProperty
    private int arr_sid;
    @JsonProperty
    private boolean direct_bus_route;

    //Default constructor
    public JsonResult() {
    }
    //Constructor with params
    public JsonResult(int dep_sid, int arr_sid, boolean direct_bus_route) {
        this.dep_sid = dep_sid;
        this.arr_sid = arr_sid;
        this.direct_bus_route = direct_bus_route;
    }

    //Getters and Setters for JsonObject
    public int getDep_sid() {
        return dep_sid;
    }

    public void setDep_sid(int dep_sid) {
        this.dep_sid = dep_sid;
    }

    public int getArr_sid() {
        return arr_sid;
    }

    public void setArr_sid(int arr_sid) {
        this.arr_sid = arr_sid;
    }

    public boolean isDirect_bus_route() {
        return direct_bus_route;
    }

    public void setDirect_bus_route(boolean direct_bus_route) {
        this.direct_bus_route = direct_bus_route;
    }


}
