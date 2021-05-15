package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.repository.CityRepository;
import com.thehamzarocks.bookmyticket.repository.ShowRepository;
import com.thehamzarocks.bookmyticket.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookMyTicketController {

  // TODO: make final

  @Autowired
  CityRepository cityRepository;

  @Autowired
  TheatreRepository theatreRepository;

  @Autowired
  ShowRepository showRepository;


  @GetMapping("/cities")
  public List<City> getCities() {
    return cityRepository.findAll();
  }

  @GetMapping("/cityTheatresAndMovies/{id}")
  public List<Theatre> getCityInfo(@PathVariable("id") Long cityId) {
    return theatreRepository.getTheatresForCity(cityId);
  }


  @GetMapping("/shows")
  public List<Show> getShows(
      @RequestParam(value = "theatre", required = false) String theatreId,
      @RequestParam(value = "movie", required = false) String movie) {
    return showRepository.findAll();
  }

  @GetMapping("/show/{id}")
  public Show getShowDetails(@PathVariable("id") Long id) {
    return showRepository.findById(id).orElseThrow();
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
