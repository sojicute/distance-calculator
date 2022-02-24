package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.Distance;
import com.sojicute.distancecalculator.repository.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public Distance getDistance(Long fromId, Long toId) {
        return distanceRepository.findDistanceByFromCityIdAndToCityId(fromId, toId);
    }

    @Override
    public void save(Distance distance) {
        if (!distanceRepository.existsDistanceByFromCityAndToCity(distance.getFromCity(), distance.getToCity())) {
            distanceRepository.save(distance);
        }
    }

}
