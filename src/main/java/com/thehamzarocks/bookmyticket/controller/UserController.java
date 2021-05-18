package com.thehamzarocks.bookmyticket.controller;

import com.thehamzarocks.bookmyticket.entity.User;
import com.thehamzarocks.bookmyticket.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired UserRepository userRepository;

  @GetMapping("/users")
  @ApiOperation("Get all users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }
}
