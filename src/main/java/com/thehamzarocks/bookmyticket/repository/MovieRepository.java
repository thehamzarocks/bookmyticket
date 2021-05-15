package com.thehamzarocks.bookmyticket.repository;

import com.thehamzarocks.bookmyticket.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
