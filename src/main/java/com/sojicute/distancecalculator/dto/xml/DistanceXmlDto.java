package com.sojicute.distancecalculator.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;


@Data
public class DistanceXmlDto {

    @JacksonXmlProperty
    private String fromCity;

    @JacksonXmlProperty
    private String toCity;

    @JacksonXmlProperty
    private double distance;
}
