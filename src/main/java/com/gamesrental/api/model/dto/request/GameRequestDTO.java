package com.gamesrental.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameRequestDTO {

    @NotBlank(message = "O campo title não pode ser vazio.")
    private String title;

    @NotBlank(message = "O campo platform não pode ser vazio.")
    private String platform;

    @NotBlank(message = "O campo genre não pode ser vazio.")
    private String genre;

    @NotNull(message = "O campo releaseYear não pode ser nulo.")
    private Integer releaseYear;

    @NotNull(message = "O campo dailyFee não pode ser nulo.")
    private BigDecimal dailyFee;

    @NotNull(message = "O campo quantity não pode ser nulo.")
    private Integer quantity;

}
