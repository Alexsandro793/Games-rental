package com.gamesrental.api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDTO {

    private UUID customerId;
    private String name;
    private String email;
    private String phone;

}
