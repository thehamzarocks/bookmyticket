package com.thehamzarocks.bookmyticket.dto;

public class Seat {

  Long id;

  private String name;

  private String status;

  public Seat() {}

  public Seat(String name, String status, TheatreShow theatreShow) {
    this.name = name;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
