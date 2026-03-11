package ie.atu.ooplab5.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String reservationNotFound) {
        super(reservationNotFound);

    }
}
