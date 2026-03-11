package ie.atu.ooplab5.exception;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String timeSlotAlreadyBooked) {
        super(timeSlotAlreadyBooked);
    }
}
