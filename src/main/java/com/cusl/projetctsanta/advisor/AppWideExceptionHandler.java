package com.cusl.projetctsanta.advisor;



import com.cusl.projetctsanta.dto.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 10/31/2022
 **/

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    protected ResponseEntity ExceptionHandler(RuntimeException e){
        return new ResponseEntity(
                new StandardResponse(404, "Error", e.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
