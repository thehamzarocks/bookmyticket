package com.thehamzarocks.bookmyticket.configuration;

import com.thehamzarocks.bookmyticket.entity.*;
import com.thehamzarocks.bookmyticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
      Movie timeMovie = new Movie("Time");
      movieRepository.save(theBigShortMovie);
      movieRepository.save(theBigShortMovie);
      movieRepository.save(theBigShortMovie);
      movieRepository.save(theBigShortMovie);
      movieRepository.save(timeMovie);

      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              theBigShortMovie,
              new ArrayList<>()));

      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              timeMovie,
              new ArrayList<>()));
      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              theBigShortMovie,
              new ArrayList<>()));
      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              theBigShortMovie,
              new ArrayList<>()));
      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              theBigShortMovie,
              new ArrayList<>()));
      showRepository.save(
          new Show(
              1L,
              "noon",
              new GregorianCalendar(2021, Calendar.MAY, 25).getTime(),
              niceMoviesTheatre,
              timeMovie,
              new ArrayList<>()));
    };
  }
}
