package com.thehamzarocks.bookmyticket.repository;

import com.thehamzarocks.bookmyticket.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
  List<Theatre> findByCityId(Long cityId);
}
