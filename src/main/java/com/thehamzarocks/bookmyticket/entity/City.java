package com.thehamzarocks.bookmyticket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "City")
public class City {
  private @Id @GeneratedValue Long id;
  private String name;

  public City() {}

  public City(String name) {
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
    if (!(o instanceof City)) return false;
    City city = (City) o;
    return id.equals(city.id) && name.equals(city.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "City{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
