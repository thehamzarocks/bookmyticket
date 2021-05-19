package com.thehamzarocks.bookmyticket.unit;

import com.thehamzarocks.bookmyticket.service.AuthService;
import com.thehamzarocks.bookmyticket.service.TheatreService;
import com.thehamzarocks.bookmyticket.dao.MovieDao;
import com.thehamzarocks.bookmyticket.dao.ShowDao;
import com.thehamzarocks.bookmyticket.dto.BookShowRequest;
import com.thehamzarocks.bookmyticket.entity.Show;
import com.thehamzarocks.bookmyticket.entity.User;
import com.thehamzarocks.bookmyticket.exception.BookMyTicketAuthenticationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;


import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShowTest {

  @InjectMocks
  TheatreService theatreService;

  @Mock
  RestTemplate restTemplate;

  @Mock
  AuthService authService;

  @Mock
  ShowDao showDao;

  @Mock
  MovieDao movieDao;

  @Test
  public void bookShowSuccess() {
    when(authService.getAuthenticatedUser()).thenReturn(new User("Jill"));
    when(showDao.findShowById(5L)).thenReturn(new Show());
    when(restTemplate.postForObject(anyString(), any(), any())).thenReturn("Booked!");
    List<Long> seatsToBook = List.of(98L, 234L, 355L);
    BookShowRequest bookShowRequest = new BookShowRequest(53L, "Jill", seatsToBook, false);
    String response = theatreService.bookShow(5L, bookShowRequest);
    assertEquals("Booked!", response);
  }

  @Test
  public void bookShowUnauthenticatedException() {
    when(authService.getAuthenticatedUser()).thenThrow(new BookMyTicketAuthenticationException("Unauthenticated"));
    List<Long> seatsToBook = List.of(98L, 234L, 355L);
    BookShowRequest bookShowRequest = new BookShowRequest(53L, "Jill", seatsToBook, false);
    Exception exception = assertThrows(BookMyTicketAuthenticationException.class, () -> theatreService.bookShow(5L, bookShowRequest));
  }
}
