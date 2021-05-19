package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Theatre")
public class Theatre {
  private @Id @GeneratedValue Long id;
  private String name;

  @ManyToOne private City city;

  public Theatre() {}

  public Theatre(String name, City city) {
    this.name = name;
    this.city = city;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
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
}
