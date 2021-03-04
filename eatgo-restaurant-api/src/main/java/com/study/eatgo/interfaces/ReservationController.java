package com.study.eatgo.interfaces;

import com.study.eatgo.domain.Reservation;
import io.jsonwebtoken.Claims;
import com.study.eatgo.application.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> list(
            Authentication authentication
    ) {
        Claims claims = (Claims) authentication.getPrincipal();

        Long restaurantId = claims.get("restaurantId", Long.class);

        List<Reservation> reservations =
                reservationService.getReservations(restaurantId);

        return reservations;
    }

}
