package com.gamesrental.api.interfaces;

import com.gamesrental.api.model.dto.request.GameRequestDTO;
import com.gamesrental.api.model.dto.response.GameResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IGameService {

    List<GameResponseDTO> findAll();
    GameResponseDTO findById(UUID id);
    GameResponseDTO create(GameRequestDTO request);
    void delete(UUID id);
    GameResponseDTO update(UUID id, GameRequestDTO request);

}
