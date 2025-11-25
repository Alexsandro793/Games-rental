package com.gamesrental.api.service.game;

import com.gamesrental.api.exception.NotFoundException;
import com.gamesrental.api.interfaces.IGameService;
import com.gamesrental.api.model.dto.request.GameRequestDTO;
import com.gamesrental.api.model.dto.response.GameResponseDTO;
import com.gamesrental.api.model.entity.Game;
import com.gamesrental.api.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements IGameService {

    private final GameRepository repository;
    private final GameMapper mapper;

    @Override
    public List<GameResponseDTO> findAll() {
        return mapper.mapEntityToDTO(repository.findAll());
    }

    @Override
    public GameResponseDTO findById(UUID id) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Jogo não encontrado."));
        return mapper.mapEntityToDTO(game);
    }

    @Override
    public GameResponseDTO create(GameRequestDTO request) {
        Game newGame = mapper.mapDTOToEntity(request);
        repository.save(newGame);
        return mapper.mapEntityToDTO(newGame);
    }

    @Override
    public GameResponseDTO update(UUID id, GameRequestDTO request) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Jogo não encontrado."));

        mapper.updateEntityWithDTO(game, request);

        repository.save(game);

        return mapper.mapEntityToDTO(game);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
