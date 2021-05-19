package com.thehamzarocks.bookmyticket.service;

import com.thehamzarocks.bookmyticket.entity.User;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketAuthenticationException;
import com.thehamzarocks.bookmyticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired UserRepository userRepository;

  public User getAuthenticatedUser() {
    return userRepository
        .findById(1L)
        .orElseThrow(() -> new BookMyTicketAuthenticationException("Authentication failed!"));
  }
}
