package com.sojicute.distancecalculator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDTO {

    @JsonProperty("from_city")
    private String fromCity;

    @JsonProperty("to_city")
    private String toCity;

    @JsonProperty("crowflight_distance")
    @JsonInclude(Include.NON_NULL)
    private Double crowflightDistance;

    @JsonProperty("matrix_distance")
    @JsonInclude(Include.NON_NULL)
    private Double matrixDistance;

    @JsonProperty("error")
    @JsonInclude(Include.NON_NULL)
    private String error;


    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Double getCrowflightDistance() {
        return crowflightDistance;
    }

    public void setCrowflightDistance(Double crowflightDistance) {
        this.crowflightDistance = crowflightDistance;
    }

    public Double getMatrixDistance() {
        return matrixDistance;
    }

    public void setMatrixDistance(Double matrixDistance) {
        this.matrixDistance = matrixDistance;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
