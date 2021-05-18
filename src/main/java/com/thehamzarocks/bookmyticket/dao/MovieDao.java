package com.thehamzarocks.bookmyticket.dao;

import com.thehamzarocks.bookmyticket.entity.Movie;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketNoSuchEntityException;
import com.thehamzarocks.bookmyticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDao {

  @Autowired MovieRepository movieRepository;

  public Movie findMovieById(Long movieId) {
    return movieRepository
        .findById(movieId)
        .orElseThrow(
            () -> new BookMyTicketNoSuchEntityException("No movie found for id: " + movieId));
  }
}
