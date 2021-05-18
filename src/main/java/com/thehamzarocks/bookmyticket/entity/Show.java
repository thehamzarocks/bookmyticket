package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Show")
public class Show {
  @Id @GeneratedValue Long id;

  private Long theatreShowId;

  private String time;

  @OneToOne Theatre theatre;

  @OneToOne Movie movie;

  // TODO: do we need to persist this?
  @Transient
  private List<Seat> seats;

  public Show() {}

  public Show(Long theatreShowId, String time, Theatre theatre, Movie movie, List<Seat> seats) {
    this.theatreShowId = theatreShowId;
    this.time = time;
    this.theatre = theatre;
    this.movie = movie;
    this.seats = seats != null ? seats : new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTheatreShowId() {
    return theatreShowId;
  }

  public void setTheatreShowId(Long theatreShowId) {
    this.theatreShowId = theatreShowId;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public void setTheatre(Theatre theatre) {
    this.theatre = theatre;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }
}
