package com.thehamzarocks.bookmyticket.service;

import com.thehamzarocks.bookmyticket.dto.BookShowRequest;
import com.thehamzarocks.bookmyticket.dao.MovieDao;
import com.thehamzarocks.bookmyticket.dao.ShowDao;
import com.thehamzarocks.bookmyticket.dto.TheatreShow;
import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.MovieRepository;
import com.thehamzarocks.bookmyticket.repository.ShowRepository;
import com.thehamzarocks.bookmyticket.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TheatreService {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }

  @Autowired RestTemplate restTemplate;

  @Autowired ShowRepository showRepository;

  @Autowired TheatreRepository theatreRepository;

  @Autowired MovieRepository movieRepository;

  @Autowired AuthService authService;

  @Autowired ShowDao showDao;

  @Autowired MovieDao movieDao;

  private static final String theatreUrl = "http://localhost:8081/";

  private String constructTheatreEndpoint(final String path) {
    return theatreUrl + path;
  }

  public List<TheatreShow> getShowsFromTheatre() {
    return restTemplate.getForObject(constructTheatreEndpoint("show/"), List.class);
  }

  public TheatreShow getShowFromTheatre(Long id) {
    Show show = showDao.findShowById(id);
    return restTemplate.getForObject(
        constructTheatreEndpoint("show/" + show.getTheatreShowId()), TheatreShow.class);
  }

  public String bookShow(Long id, BookShowRequest bookShowRequest) {
    User user = authService.getAuthenticatedUser();
    bookShowRequest.setUserName(user.getName());
    Show show = showDao.findShowById(id);
    return restTemplate.postForObject(
        constructTheatreEndpoint("booking/" + show.getTheatreShowId()),
        bookShowRequest,
        String.class);
  }

  public String addShowDetails(List<TheatreShow> addShowDetails) {
    if (addShowDetails == null || addShowDetails.isEmpty()) {
      return "No request body found";
    }
    Long theatreId = addShowDetails.get(0).getTheatreId();
    Theatre theatre =
        theatreRepository.findById(theatreId).orElseThrow();
    addShowDetails.forEach(
        showDetail -> {
          Movie movie = movieDao.findMovieById(showDetail.getMovieId());
          Show show =
              new Show(
                  showDetail.getId(),
                  showDetail.getTime(),
                  showDetail.getDate(),
                  theatre,
                  movie,
                  showDetail.getSeats());
          showRepository.save(show);
        });
    return "Success!";
  }
}
