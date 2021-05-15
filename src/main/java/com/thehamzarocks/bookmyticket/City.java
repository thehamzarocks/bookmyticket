package com.thehamzarocks.bookmyticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "City")
public class City {
  private @Id @GeneratedValue Long cityId;
  private String name;

  public City() {}

  public City(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.cityId;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.cityId = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof City)) return false;
    City city = (City) o;
    return cityId.equals(city.cityId) && name.equals(city.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cityId, name);
  }

  @Override
  public String toString() {
    return "City{" + "id=" + cityId + ", name='" + name + '\'' + '}';
  }
}
