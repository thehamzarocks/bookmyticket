package com.thehamzarocks.bookmyticket.repository;

import com.thehamzarocks.bookmyticket.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
  public List<Show> findByTheatreIdAndMovieId(Long theatreId, Long movieId);
}
