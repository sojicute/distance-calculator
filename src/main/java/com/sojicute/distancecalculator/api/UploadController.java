package com.sojicute.distancecalculator.api;

import com.sojicute.distancecalculator.service.DeserializeXmlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class UploadController {

    @Autowired
    private DeserializeXmlServiceImpl deserializeXmlService;

    @PostMapping( value = "/upload/city", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> uploadCities(@RequestPart("file") MultipartFile file) {
        deserializeXmlService.deserializeCityXml(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping( value ="/upload/distance", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> uploadDistance(@RequestPart("file") MultipartFile file) {
        deserializeXmlService.deserializeDistanceXml(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
