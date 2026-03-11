package ie.atu.ooplab5.service;

import ie.atu.ooplab5.model.Reservation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public Reservation addReservation(@Valid Reservation reservation) {
        return new Reservation();
    }
}
