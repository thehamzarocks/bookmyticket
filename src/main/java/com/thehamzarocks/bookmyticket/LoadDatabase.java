package com.thehamzarocks.bookmyticket;

import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class LoadDatabase {

  @Autowired UserRepository userRepository;

  @Autowired CityRepository cityRepository;

  @Autowired TheatreRepository theatreRepository;

  @Autowired MovieRepository movieRepository;

  @Autowired ShowRepository showRepository;

  @Bean
  CommandLineRunner initDatabase() {
    return args -> {
      userRepository.save(new User("Jill"));
      City smallCity = new City("SmallCity");
      cityRepository.save(smallCity);
      cityRepository.save(new City("BigCity"));
      cityRepository.save(new City("TooCity"));

      Theatre niceMoviesTheatre = new Theatre("Nice Movies Theatre", smallCity);
      theatreRepository.save(niceMoviesTheatre);

      Movie theBigShortMovie = new Movie("The Big Short");
      movieRepository.save(theBigShortMovie);

      showRepository.save(
          new Show(1L, "noon", niceMoviesTheatre, theBigShortMovie, new ArrayList<>()));
    };
  }
}
