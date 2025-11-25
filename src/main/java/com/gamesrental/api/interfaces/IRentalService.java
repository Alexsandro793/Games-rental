package com.gamesrental.api.interfaces;

import com.gamesrental.api.model.dto.request.RentalRequestDTO;
import com.gamesrental.api.model.dto.response.RentalResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IRentalService {

    List<RentalResponseDTO> findAll();
    RentalResponseDTO findById(UUID id);
    RentalResponseDTO create(RentalRequestDTO request);
    RentalResponseDTO rentalReturn(UUID id);

}
