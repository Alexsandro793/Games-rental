package com.gamesrental.api.controller;

import com.gamesrental.api.model.dto.request.RentalRequestDTO;
import com.gamesrental.api.model.dto.response.RentalResponseDTO;
import com.gamesrental.api.service.rental.RentalServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalServiceImpl service;

    @GetMapping
    public ResponseEntity<List<RentalResponseDTO>> getAll() {
        List<RentalResponseDTO> rentals = service.findAll();

        if (rentals.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rentals);
    }


    @GetMapping("/{id}")
    private ResponseEntity<RentalResponseDTO> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    private ResponseEntity<RentalResponseDTO> create(@Valid @RequestBody RentalRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}/return")
    private ResponseEntity<RentalResponseDTO> rentalReturn(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.rentalReturn(id));
    }

}
