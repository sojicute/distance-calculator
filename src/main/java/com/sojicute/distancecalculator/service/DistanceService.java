package com.sojicute.distancecalculator.service;

import com.sojicute.distancecalculator.domain.Distance;

public interface DistanceService {
    Distance getDistance(Long From, Long toId);
    void save(Distance distance);
}
