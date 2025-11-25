package com.gamesrental.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequestDTO {

    @NotNull(message = "O campo customerId não pode ser nulo.")
    private UUID customerId;

    @NotNull(message = "O campo gameId não pode ser nulo.")
    private UUID gameId;

}
