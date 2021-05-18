package com.thehamzarocks.bookmyticket.exception;

public class BookMyTicketAuthenticationException extends RuntimeException{
  public BookMyTicketAuthenticationException(String errorMessage) {
    super(errorMessage);
  }
  public BookMyTicketAuthenticationException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
