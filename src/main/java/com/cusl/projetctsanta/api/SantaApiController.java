package com.cusl.projetctsanta.api;

import com.cusl.projetctsanta.dto.ResultDTO;
import com.cusl.projetctsanta.dto.StandardResponse;
import com.cusl.projetctsanta.services.SantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        int count = santaService.getCount(100);
        return new ResponseEntity<>(
                new StandardResponse(201, "success", count),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> selectSanta(){
        ResultDTO resultDTO = santaService.selectSanta(50, 3);
        return new ResponseEntity<>(
                new StandardResponse(201, "success", resultDTO),
                HttpStatus.CREATED
        );
    }

}
