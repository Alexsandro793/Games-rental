package com.gamesrental.api.controller;

import com.gamesrental.api.model.dto.request.GameRequestDTO;
import com.gamesrental.api.model.dto.response.GameResponseDTO;
import com.gamesrental.api.service.game.GameServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameServiceImpl service;

    @GetMapping
    public ResponseEntity<List<GameResponseDTO>> getAll() {
        List<GameResponseDTO> games = service.findAll();

        if (games.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDTO> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<GameResponseDTO> create(@Valid @RequestBody GameRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponseDTO> update(
            @PathVariable("id") UUID id,
            @Valid @RequestBody GameRequestDTO request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}