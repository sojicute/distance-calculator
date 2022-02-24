package com.sojicute.distancecalculator.api;

import com.sojicute.distancecalculator.dto.CalculateType;
import com.sojicute.distancecalculator.dto.ResultDTO;
import com.sojicute.distancecalculator.service.CalculateDistanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DistanceController {

    @Autowired
    private CalculateDistanceServiceImpl calculateDistanceService;


    @PostMapping("/distance-calculator/calculate")
    public ResponseEntity<List<ResultDTO>> calculate(@RequestParam List<String> fromCity, @RequestParam List<String> toCity, @RequestParam CalculateType type) {
        List<ResultDTO> distances = calculateDistanceService.calculate(fromCity, toCity, type);
        return new ResponseEntity<>(distances, HttpStatus.OK);
    }
}
