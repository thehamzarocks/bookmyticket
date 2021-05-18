package com.thehamzarocks.bookmyticket;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class ResponseWrapper<T> {
  String status;
  String message;
  T body;

  public ResponseWrapper() {
  }

  public ResponseWrapper(String status, String message, T body) {
    this.status = status;
    this.message = message;
    this.body = body;
  }

  public ResponseEntity<ResponseWrapper<T>> constructResponse(
      HttpStatus status, String message, T body) {

    return new ResponseEntity<>(new ResponseWrapper<>(status.toString(), message, body), status);
  }
}
