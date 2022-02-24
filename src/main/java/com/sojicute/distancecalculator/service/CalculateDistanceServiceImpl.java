package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.domain.Distance;
import com.sojicute.distancecalculator.dto.CalculateType;
import com.sojicute.distancecalculator.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateDistanceServiceImpl implements CalculateDistanceService {

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private CityService cityService;

    public List<ResultDTO> calculate(List<String> fromCityList, List<String> toCityList, CalculateType type) {
        List<ResultDTO> distances = new ArrayList<>();

        switch (type) {
            case MATRIX:
                distances = calculateMatrixDistance(cityService.findCitiesByName(fromCityList), cityService.findCitiesByName(toCityList));
                break;
            case CROWFLIGHT:
                distances = calculateCrowFlightDistance(cityService.findCitiesByName(fromCityList), cityService.findCitiesByName(toCityList));
                break;
            case ALL:
                distances = calculateAllDistance(cityService.findCitiesByName(fromCityList), cityService.findCitiesByName(toCityList));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return distances;
    }

    @Override
    public List<ResultDTO> calculateCrowFlightDistance(List<City> fromCityList, List<City> toCityList) {
        List<ResultDTO> results = new ArrayList<>();

        for (City fromCity : fromCityList) {
            for(City toCity : toCityList) {
                double crowFlightDistance = getCrowflightDitstance(fromCity.getLatitude(), fromCity.getLongitude(),
                        toCity.getLatitude(), toCity.getLongitude());

                ResultDTO result = new ResultDTO();
                result.setFromCity(fromCity.getName());
                result.setToCity(toCity.getName());
                result.setCrowflightDistance(crowFlightDistance);

                results.add(result);
            }
        }
        return results;
    }

    @Override
    public List<ResultDTO> calculateMatrixDistance(List<City> fromCityList, List<City> toCityList) {
        List<ResultDTO> results = new ArrayList<>();

        for (City fromCity : fromCityList) {
            for(City toCity : toCityList) {
                ResultDTO result = new ResultDTO();

                Distance distance = distanceService.getDistance(fromCity.getId(), toCity.getId());

                if (distance != null) {
                    result.setMatrixDistance(distance.getDistance());
                } else {
                    result.setError("Matrix distance between "+fromCity.getName()+" and " +toCity.getName()+ " not found");
                }

                result.setFromCity(fromCity.getName());
                result.setToCity(toCity.getName());

                results.add(result);
            }
        }
        return results;
    }

    @Override
    public List<ResultDTO> calculateAllDistance(List<City> fromCityList, List<City> toCityList) {
        List<ResultDTO> results = new ArrayList<>();
        Double crowFlightDistance;
        for (City fromCity : fromCityList) {
            for(City toCity : toCityList) {
                ResultDTO result = new ResultDTO();
                crowFlightDistance = getCrowflightDitstance(fromCity.getLatitude(), fromCity.getLongitude(),
                        toCity.getLatitude(), toCity.getLongitude());

                Distance distance = distanceService.getDistance(fromCity.getId(), toCity.getId());

                if (distance != null) {
                    result.setMatrixDistance(distance.getDistance());
                } else {
                    result.setError("Matrix distance between "+fromCity.getName()+" and " +toCity.getName()+ " not found");
                }

                result.setFromCity(fromCity.getName());
                result.setToCity(toCity.getName());
                result.setCrowflightDistance(crowFlightDistance);

                results.add(result);
            }
        }
        return results;
    }


    private Double getCrowflightDitstance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = toRad(lat2 - lat1);
        double lonDistance = toRad(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double result = R * c;
        return result;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
