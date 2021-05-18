package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookMyTicketController {

  // TODO: make final

  @Autowired CityRepository cityRepository;

  @Autowired TheatreRepository theatreRepository;

  @Autowired MovieRepository movieRepository;

  @Autowired ShowRepository showRepository;

  @Autowired TheatreService theatreService;

  @Autowired UserRepository userRepository;

  @GetMapping("/cities")
  public List<City> getCities() {
    return cityRepository.findAll();
  }

  @GetMapping("/city/theatres/{cityId}")
  public List<Theatre> getCityInfo(@PathVariable("cityId") Long cityId) {
    return theatreRepository.findByCityId(cityId);
  }

  @GetMapping("/movies")
  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  @GetMapping("/shows")
  public List<Show> getShows(
      @RequestParam(value = "theatre", required = false) Long theatreId,
      @RequestParam(value = "movie", required = false) Long movie) {
    if (theatreId == null || movie == null) {
      return showRepository.findAll();
    }
    return showRepository.findByTheatreIdAndMovieId(theatreId, movie);
  }

  @GetMapping("/show/{id}")
  public TheatreShow getShowDetails(@PathVariable("id") Long id) {
    return theatreService.getShowFromTheatre(id);
  }

  @PostMapping("/booking/{id}")
  public String bookShow(
      @PathVariable("id") final Long id, @RequestBody BookShowRequest bookShowRequest) {
    return theatreService.bookShow(id, bookShowRequest);
  }

  @PostMapping("/shows")
  public String addShowDetails(@RequestBody List<TheatreShow> showsToAdd) {
    return theatreService.addShowDetails(showsToAdd);
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }
}
