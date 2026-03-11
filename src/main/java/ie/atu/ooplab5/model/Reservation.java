package ie.atu.ooplab5.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private Long reservationId;

    @NotBlank(message = "Equipment tag is required")
    private String equipmentTag;

    @NotBlank(message = "Student email is required")
    @Email(message = "Not a valid email")
    private String studentEmail;

    @NotNull(message = "Reservation date is required")
    private LocalDate reservationDate;

    @Min(value = 1, message = "start hours must be between 0 and 23")
    @Max(value = 23, message = "start hours must be between 0 and 23")
    private int startHour;

    @Min(value = 1, message = "duration hours must be between 1 and 23")
    @Max(value = 24, message = "duration hours must be between 1 and 23")
    private int durationHours;
}
