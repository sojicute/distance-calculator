package com.sojicute.distancecalculator.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.domain.Distance;
import com.sojicute.distancecalculator.dto.xml.CitiesXmlDto;
import com.sojicute.distancecalculator.dto.xml.CityXmlDto;
import com.sojicute.distancecalculator.dto.xml.DistanceXmlDto;
import com.sojicute.distancecalculator.dto.xml.DistancesXmlDto;
import com.sojicute.distancecalculator.exception.DeserializeFromXmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeserializeXmlServiceImpl implements DeserializeXmlService{

    @Autowired
    private CityService cityService;

    @Autowired
    private DistanceService distanceService;


    @Override
    public void deserializeDistanceXml(MultipartFile file) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(file.getInputStream());
            DistancesXmlDto distancesXmlDto = xmlMapper.readValue(xml, DistancesXmlDto.class);

            List<Distance> distances = distancesXmlDto.getDistances().stream().map(this::toDistance).collect(Collectors.toList());

            for (Distance d: distances){
                distanceService.save(d);
            }

        } catch (IOException e) {
            throw new DeserializeFromXmlException("Error deserialize XML file with distance", e);
        }
    }
    @Override
    public void deserializeCityXml(MultipartFile file) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(file.getInputStream());
            CitiesXmlDto citiesXmlDto = xmlMapper.readValue(xml, CitiesXmlDto.class);

            List<City> cities = citiesXmlDto.getCities().stream().map(this::toCity).collect(Collectors.toList());

            for (City city : cities) {
                cityService.save(city);
            }

        } catch (IOException e) {
            throw new DeserializeFromXmlException("Error deserialize XML file with cities", e);
        }
    }

    public City toCity(CityXmlDto cityXmlDto) {
        City city = new City();
        city.setName(cityXmlDto.getName());
        city.setLatitude(cityXmlDto.getLatitude());
        city.setLongitude(cityXmlDto.getLongitude());
        return city;
    }

    public Distance toDistance(DistanceXmlDto distanceXmlDto) {
        Distance distance = new Distance();
        distance.setFromCity(cityService.findCityByName(distanceXmlDto.getFromCity()));
        distance.setToCity(cityService.findCityByName(distanceXmlDto.getToCity()));
        distance.setDistance(distanceXmlDto.getDistance());
        return distance;
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
