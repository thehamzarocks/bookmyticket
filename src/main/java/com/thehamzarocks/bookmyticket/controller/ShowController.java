package com.thehamzarocks.bookmyticket.controller;

import com.thehamzarocks.bookmyticket.ResponseWrapper;
import com.thehamzarocks.bookmyticket.TheatreService;
import com.thehamzarocks.bookmyticket.dao.BookShowRequest;
import com.thehamzarocks.bookmyticket.dao.ShowDao;
import com.thehamzarocks.bookmyticket.entity.Show;
import com.thehamzarocks.bookmyticket.entity.TheatreShow;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketAuthenticationException;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketNoSuchEntityException;
import com.thehamzarocks.bookmyticket.repository.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {

  @Autowired CityRepository cityRepository;

  @Autowired TheatreRepository theatreRepository;

  @Autowired MovieRepository movieRepository;

  @Autowired ShowRepository showRepository;

  @Autowired TheatreService theatreService;

  @Autowired UserRepository userRepository;

  @Autowired ResponseWrapper responseWrapper;

  @Autowired
  ShowDao showDao;

  @GetMapping("/shows")
  @ApiOperation("Get all shows")
  public ResponseEntity<?> getShows(
      @RequestParam(value = "theatre", required = false) Long theatreId,
      @RequestParam(value = "movie", required = false) Long movie) {
    if (theatreId == null || movie == null) {
      return new ResponseEntity<>(showRepository.findAll(PageRequest.of(0, 100)).getContent(), HttpStatus.OK);
    }
    return new ResponseEntity<>(showRepository.findByTheatreIdAndMovieId(theatreId, movie), HttpStatus.OK);
  }

  @GetMapping("/show/{id}")
  @ApiOperation("Get details for the given show")
  public TheatreShow getShowDetails(@PathVariable("id") Long id) {
    return theatreService.getShowFromTheatre(id);
  }

  @PostMapping("/booking/{id}")
  @ApiOperation("Book seats for the specified show")
  public ResponseEntity<String> bookShow(
      @PathVariable("id") final Long id, @RequestBody BookShowRequest bookShowRequest) {
    try {
      return new ResponseEntity<>(theatreService.bookShow(id, bookShowRequest), HttpStatus.OK);
    } catch (BookMyTicketNoSuchEntityException e) {
      return new ResponseEntity<>("Unable to find the entities from the request", HttpStatus.NOT_FOUND);
    } catch (BookMyTicketAuthenticationException e) {
      return new ResponseEntity<>("Unauthenticated", HttpStatus.UNAUTHORIZED);
    } catch (Exception e) {
      return new ResponseEntity<>("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/shows")
  @ApiOperation("Add new shows")
  public String addShowDetails(@RequestBody List<TheatreShow> showsToAdd) {
    return theatreService.addShowDetails(showsToAdd);
  }
}
