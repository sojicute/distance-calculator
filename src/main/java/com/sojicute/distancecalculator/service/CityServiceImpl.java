package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.dto.CityDTO;
import com.sojicute.distancecalculator.repository.CityRepository;
import com.sojicute.distancecalculator.repository.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public List<CityDTO> findAll() {
        return cityRepository.findAll().stream().map(this::toCityDto).collect(Collectors.toList());
    }

    @Override
    public List<City> findCitiesByName(List<String> cityNames) {
        List<City> cities = cityRepository.findCitiesByNameIn(cityNames);
        return cities;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public void save(City city) {
        if (!cityRepository.existsCityByName(city.getName())) {
            cityRepository.saveAndFlush(city);
        }
    }


    private CityDTO toCityDto(City city) {
        CityDTO cityDto = new CityDTO();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }

}
