package com.gamesrental.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDTO {

    @NotBlank(message = "Campo name não pode ser vazio")
    private String name;

    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;

    @NotBlank(message = "Campo phone não pode ser vazio")
    private String phone;

}
