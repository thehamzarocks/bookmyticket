package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.MovieRepository;
import com.thehamzarocks.bookmyticket.repository.ShowRepository;
import com.thehamzarocks.bookmyticket.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class TheatreService {
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }

  @Autowired RestTemplate restTemplate;

  @Autowired ShowRepository showRepository;

  @Autowired
  TheatreRepository theatreRepository;

  @Autowired
  MovieRepository movieRepository;

  @Autowired AuthService authService;

  private static final String theatreUrl = "http://localhost:8081";

  public List<TheatreShow> getShowsFromTheatre() {
    return restTemplate.getForObject(String.format("%s/%s", theatreUrl, "show/"), List.class);
  }

  public TheatreShow getShowFromTheatre(Long id) {
    Show show = showRepository.findById(id).orElseThrow();
    return restTemplate.getForObject(
        String.format("%s/%s%s", theatreUrl, "show/", show.getTheatreShowId()), TheatreShow.class);
  }

  public String bookShow(Long id, BookShowRequest bookShowRequest) {
    User user = authService.getAuthenticatedUser();
    bookShowRequest.setUserName(user.getName());
    Show show = showRepository.findById(id).orElseThrow();
    return restTemplate.postForObject(
        String.format("%s/%s%s", theatreUrl, "booking/", show.getTheatreShowId()), bookShowRequest, String.class);
  }

  public String addShowDetails(List<TheatreShow> addShowDetails) {
    if(addShowDetails == null) {
      return "No request body found";
    }

    Theatre theatre = theatreRepository.findById(addShowDetails.get(0).getTheatreId()).orElseThrow();
    addShowDetails.forEach(showDetail -> {
      Movie movie = movieRepository.findById(showDetail.getMovieId()).orElseThrow();
      Show show = new Show(showDetail.getId(), "morning", theatre, movie, showDetail.getSeats());
      showRepository.save(show);
    });
    return "Success!";
  }
}
