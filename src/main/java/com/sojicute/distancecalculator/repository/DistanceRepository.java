package com.sojicute.distancecalculator.repository;

import com.sojicute.distancecalculator.domain.City;
import com.sojicute.distancecalculator.domain.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
    @Query("select d from Distance d where d.fromCity.id = :fromId and d.toCity.id = :toId")
    Distance findDistanceByFromCityIdAndToCityId(@Param("fromId") Long fromId, @Param("toId") Long toId);
    Boolean existsDistanceByFromCityAndToCity(City fromCity, City toCity);
}
