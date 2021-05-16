package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.entity.TheatreShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TheatreService {
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }

  @Autowired
  RestTemplate restTemplate;

  public List<TheatreShow> getShowFromTheatre() {
    return restTemplate.getForObject("http://localhost:8081/show", List.class);
  }
}
