package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
    City findById(Long id);
    City findCityByName(String name);
    void save(City city);
    List<City> findCitiesByName(List<String> cityNames);

}
