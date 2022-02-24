package com.sojicute.distancecalculator.dto.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "cities")
public class CitiesXmlDto {

    @JacksonXmlProperty(localName = "city")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<CityXmlDto> cities;
}
