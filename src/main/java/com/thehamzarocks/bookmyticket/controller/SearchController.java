package com.thehamzarocks.bookmyticket.controller;

import com.thehamzarocks.bookmyticket.service.TheatreService;
import com.thehamzarocks.bookmyticket.entity.City;
import com.thehamzarocks.bookmyticket.entity.Movie;
import com.thehamzarocks.bookmyticket.entity.Theatre;
import com.thehamzarocks.bookmyticket.repository.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
  @Autowired CityRepository cityRepository;

  @Autowired TheatreRepository theatreRepository;

  @Autowired MovieRepository movieRepository;

  @Autowired ShowRepository showRepository;

  @Autowired TheatreService theatreService;

  @Autowired UserRepository userRepository;

  @GetMapping("/cities")
  @ApiOperation("Get all cities serviced by BookMyTicket")
  public ResponseEntity<List<City>> getCities() {
    return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/city/theatres/{cityId}")
  @ApiOperation("Get all theatres in the specified city")
  public List<Theatre> getCityInfo(@PathVariable("cityId") Long cityId) {
    return theatreRepository.findByCityId(cityId);
  }

  @GetMapping("/movies")
  @ApiOperation("Get all movie details")
  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }
}
