package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.CityRepository;
import com.thehamzarocks.bookmyticket.repository.MovieRepository;
import com.thehamzarocks.bookmyticket.repository.ShowRepository;
import com.thehamzarocks.bookmyticket.repository.TheatreRepository;
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
    //    return showRepository.findAll();
  }

  @GetMapping("/show/{id}")
  public List<TheatreShow> getShowDetails(@PathVariable("id") Long id) {
      return theatreService.getShowFromTheatre();
//    return showRepository.findById(id).orElseThrow();
  }

  @PostMapping("/show/{id}")
  public String bookShow(@PathVariable("id") final String id, @RequestBody String body) {
    return "Booked show for " + body;
  }

  @PostMapping("/shows")
  public String addShowDetails(@RequestBody String showsToAdd) {
    return showsToAdd;
  }
}
