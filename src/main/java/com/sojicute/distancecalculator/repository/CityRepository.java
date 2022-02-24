package com.sojicute.distancecalculator.repository;

import com.sojicute.distancecalculator.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City findCityByName(String name);
    Boolean existsCityByName(String name);
    List<City> findCitiesByNameIn(List<String> cityNames);

}
