package com.gamesrental.api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDTO {

    private UUID id;
    private String title;
    private String platform;
    private String genre;
    private Integer releaseYear;
    private BigDecimal dailyFee;
    private Integer quantity;

}
