package com.sojicute.distancecalculator.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class CityXmlDto {

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private double latitude;

    @JacksonXmlProperty
    private double longitude;
}
