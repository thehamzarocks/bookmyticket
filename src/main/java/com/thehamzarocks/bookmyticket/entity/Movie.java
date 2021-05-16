package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {
  private @Id @GeneratedValue Long id;
  private String name;

  public Movie() {}

  public Movie(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Movie)) return false;
    Movie movie = (Movie) o;
    return id.equals(movie.id) && name.equals(movie.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Movie{" + "movieId=" + id + ", name='" + name + '\'' + '}';
  }
}
