package com.gamesrental.api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponseDTO {

    private UUID rentalId;
    private CustomerResponseDTO customer;
    private GameResponseDTO game;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private BigDecimal total;

}
