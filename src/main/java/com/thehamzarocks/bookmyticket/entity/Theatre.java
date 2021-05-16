package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Theatre")
public class Theatre {
  private @Id @GeneratedValue Long id;
  private String name;

  @ManyToOne
//  @JoinColumn(name = "id")
  private City city;

  public Theatre() {}

  public Theatre(String name, City city) {
    this.name = name;
    this.city = city;
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
    return id.equals(theatre.id) && name.equals(theatre.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Theatre{" + "theatreId=" + id + ", name='" + name + '\'' + '}';
  }
}

