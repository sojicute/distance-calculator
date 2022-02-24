package com.sojicute.distancecalculator.service;

import org.springframework.web.multipart.MultipartFile;

public interface DeserializeXmlService {
    void deserializeDistanceXml(MultipartFile file);
    void deserializeCityXml(MultipartFile file);
}
