package com.thehamzarocks.bookmyticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {
  private @Id @GeneratedValue Long movieId;
  private String name;

  public Movie() {}

  public Movie(String name) {
    this.name = name;
  }

  public Long getMovieId() {
    return this.movieId;
  }

  public String getName() {
    return this.name;
  }

  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Movie)) return false;
    Movie movie = (Movie) o;
    return movieId.equals(movie.movieId) && name.equals(movie.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId, name);
  }

  @Override
  public String toString() {
    return "Movie{" + "movieId=" + movieId + ", name='" + name + '\'' + '}';
  }
}
