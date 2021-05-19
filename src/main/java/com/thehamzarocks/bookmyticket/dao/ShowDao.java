package com.thehamzarocks.bookmyticket.dao;

import com.thehamzarocks.bookmyticket.entity.Show;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketNoSuchEntityException;
import com.thehamzarocks.bookmyticket.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShowDao {

  @Autowired ShowRepository showRepository;

  public List<Show> findAllShows() {
    List<Show> shows = showRepository.findAll();
    shows.stream().forEach(show -> {
      show.setMovie(null);
      show.setTheatre(null);
    });
    return shows;
  }

  public Show findShowById(Long showId) {
    return showRepository
        .findById(showId)
        .orElseThrow(
            () -> new BookMyTicketNoSuchEntityException("No show found for id: " + showId));
  }
}
