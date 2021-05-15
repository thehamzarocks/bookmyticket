package com.thehamzarocks.bookmyticket;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Theatre")
public class Theatre {
  private @Id @GeneratedValue Long theatreId;
  private String name;

  @ManyToOne
  @JoinColumn(name = "cityId")
  private City city;

  public Theatre() {}

  public Theatre(String name, City city) {
    this.name = name;
    this.city = city;
  }

  public Long getTheatreId() {
    return this.theatreId;
  }

  public String getName() {
    return this.name;
  }

  public void setTheatreId(Long theatreId) {
    this.theatreId = theatreId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Theatre)) return false;
    Theatre theatre = (Theatre) o;
    return theatreId.equals(theatre.theatreId) && name.equals(theatre.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theatreId, name);
  }

  @Override
  public String toString() {
    return "Theatre{" + "theatreId=" + theatreId + ", name='" + name + '\'' + '}';
  }
}

