package com.gamesrental.api.service.rental;

import com.gamesrental.api.model.dto.request.RentalRequestDTO;
import com.gamesrental.api.model.dto.response.RentalResponseDTO;
import com.gamesrental.api.model.entity.Rental;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RentalMapper {

    private final ModelMapper mapper;

    public Rental mapDTOToEntity(RentalRequestDTO source) {
        return mapper.map(source, Rental.class);
    }

    public RentalResponseDTO mapEntityToDTO(Rental source) {
        return mapper.map(source, RentalResponseDTO.class);
    }

    public List<RentalResponseDTO> mapEntityToDTO(List<Rental> source) {
        return source.stream().map(this::mapEntityToDTO).toList();
    }

}
