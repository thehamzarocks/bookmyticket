package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Show")
public class Show {
  @Id @GeneratedValue Long id;

  String showTime;

  @ManyToOne
//  @JoinColumn(name = "id")
  private Theatre theatre;

  @ManyToOne
//  @JoinColumn(name = "id")
  private Movie movie;

  public Show() {}

  public Show(String showTime, Theatre theatre, Movie movie) {
    this.showTime = showTime;
    this.theatre = theatre;
    this.movie = movie;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    return id.equals(show.id) && theatre.equals(show.theatre) && movie.equals(show.movie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, theatre, movie);
  }
}
