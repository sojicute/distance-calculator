package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.dto.ResultDTO;

import java.util.List;

public interface CalculateDistanceService {
    List<ResultDTO> calculateCrowFlightDistance(List<City> fromCityList, List<City> toCityList);
    List<ResultDTO> calculateMatrixDistance(List<City> fromCityList, List<City> toCityList);
    List<ResultDTO> calculateAllDistance(List<City> fromCityList, List<City> toCityList);
}
