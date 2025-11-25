package com.gamesrental.api.service.game;

import com.gamesrental.api.model.dto.request.GameRequestDTO;
import com.gamesrental.api.model.dto.response.GameResponseDTO;
import com.gamesrental.api.model.entity.Game;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameMapper {

    private final ModelMapper mapper;

    public GameResponseDTO mapEntityToDTO(Game source) {
        return mapper.map(source, GameResponseDTO.class);
    }

    public List<GameResponseDTO> mapEntityToDTO(List<Game> source) {
        return source.stream().map(this::mapEntityToDTO).toList();
    }

    public Game mapDTOToEntity(GameRequestDTO source) {
        return mapper.map(source, Game.class);
    }

    public void updateEntityWithDTO(Game entity, GameRequestDTO dto) {
        if (dto.getTitle() != null) {
            entity.setTitle(dto.getTitle());
        }

        if (dto.getPlatform() != null) {
            entity.setPlatform(dto.getPlatform());
        }

        if (dto.getGenre() != null) {
            entity.setGenre(dto.getGenre());
        }

        if (dto.getReleaseYear() != null) {
            entity.setReleaseYear(dto.getReleaseYear());
        }

        if (dto.getDailyFee() != null) {
            entity.setDailyFee(dto.getDailyFee());
        }

        if (dto.getQuantity() != null) {
            entity.setQuantity(dto.getQuantity());
        }
    }

}