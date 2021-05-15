package com.thehamzarocks.bookmyticket;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Show")
public class Show {
  @Id @GeneratedValue Long showId;

  String showTime;

  @ManyToOne
  @JoinColumn(name = "theatre_id")
  private Theatre theatre;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  public Show() {}

  public Show(String showTime, Theatre theatre, Movie movie) {
    this.showTime = showTime;
    this.theatre = theatre;
    this.movie = movie;
  }

  public Long getShowId() {
    return showId;
  }

  public void setShowId(Long showId) {
    this.showId = showId;
  }

  public String getShowTime() {
    return showTime;
  }

  public void setShowTime(String showTime) {
    this.showTime = showTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Show)) return false;
    Show show = (Show) o;
    return showId.equals(show.showId) && theatre.equals(show.theatre) && movie.equals(show.movie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(showId, theatre, movie);
  }
}
