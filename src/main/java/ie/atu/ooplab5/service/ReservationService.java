package ie.atu.ooplab5.service;

import ie.atu.ooplab5.exception.ReservationConflictException;
import ie.atu.ooplab5.exception.ReservationNotFoundException;
import ie.atu.ooplab5.model.Reservation;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    /// Create
    public Reservation addReservation(Reservation reservation){

        /// Assign id
        reservation.setReservationId(nextId++);

        /// check for time conflicts
        for (Reservation existing : reservations) {

            /// same equipment + same date
            if (existing.getEquipmentTag().equals(reservation.getEquipmentTag()) && existing.getReservationDate().equals(reservation.getReservationDate())) {
                int existingStart = existing.getStartHour();
                int existingEnd = existingStart + existing.getDurationHours();

                int newStart = reservation.getStartHour();
                int newEnd = newStart + reservation.getDurationHours();

                /// overlap check
                if (existingStart < newEnd && newStart < existingEnd) {
                    ///Remove id
                    reservation.setReservationId(nextId--);
                    throw new ReservationConflictException("Time Slot already booked");
                }
            }
        }

        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public @Nullable Reservation getReservationById(Long id) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(id)) {
                return reservation;
            }
        }

        throw new ReservationNotFoundException("Reservation not found");
    }
}
