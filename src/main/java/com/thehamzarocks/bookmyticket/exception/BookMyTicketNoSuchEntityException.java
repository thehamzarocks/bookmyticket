package com.thehamzarocks.bookmyticket.exception;

public class BookMyTicketNoSuchEntityException extends RuntimeException {
  public BookMyTicketNoSuchEntityException(String errorMessage) {
    super(errorMessage);
  }

  public BookMyTicketNoSuchEntityException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
