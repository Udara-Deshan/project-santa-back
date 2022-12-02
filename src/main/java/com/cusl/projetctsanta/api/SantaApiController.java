package com.cusl.projetctsanta.api;

import com.cusl.projetctsanta.dto.StandardResponse;
import com.cusl.projetctsanta.services.SantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SantaApiController {

    @Autowired
    SantaService santaService;


    @GetMapping("/count")
    public ResponseEntity<StandardResponse> getCount(){
        int count = santaService.getCount();
        return new ResponseEntity<>(
                new StandardResponse(201, "success", count),
                HttpStatus.CREATED
        );
    }

}
